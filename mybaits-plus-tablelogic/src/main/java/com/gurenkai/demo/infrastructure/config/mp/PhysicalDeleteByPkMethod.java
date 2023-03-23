package com.gurenkai.demo.infrastructure.config.mp;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class PhysicalDeleteByPkMethod extends AbstractMethod {

    protected PhysicalDeleteByPkMethod() {
        super("physicalDeleteByPk");
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        if (tableInfo.getLogicDeleteFieldInfo() == null){
            return null;
        }

        final String sql = "<script>delete from %s where %s</script>";
        final String whereSql = prepareWhereSqlForMysqlBatch(tableInfo);
        final String sqlResult = String.format(sql, tableInfo.getTableName(), whereSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        return this.addDeleteMappedStatement(mapperClass, sqlSource);
    }

    private String prepareWhereSqlForMysqlBatch(TableInfo tableInfo) {
        return tableInfo.getKeyColumn() + " in " +
                "<foreach collection='ids' item='item' index='index' open='(' separator=',' close=')'>" +
                "#{item}" +
                "</foreach>";
    }

}
