package com.gurenkai.demo.infrastructure.config.mp;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class RecoverByWrapperMethod extends AbstractMethod {

    protected RecoverByWrapperMethod() {
        super("recover");
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        if (tableInfo.getLogicDeleteFieldInfo() == null){
            return null;
        }

        final String sql = "<script>update %s set %s %s</script>";
        final String fieldSql = prepareFieldSql(tableInfo);
        final String whereSql = prepareWhereSqlForMysqlBatch(tableInfo);
        final String sqlResult = String.format(sql, tableInfo.getTableName(), fieldSql, whereSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        return this.addInsertMappedStatement(mapperClass, modelClass, "recover", sqlSource, new NoKeyGenerator(), null, null);
    }

    private String prepareFieldSql(TableInfo tableInfo) {
        final StringBuilder valueSql = new StringBuilder();
        final TableFieldInfo logicDeleteFieldInfo = tableInfo.getLogicDeleteFieldInfo();
        final String logicDeleteColum = logicDeleteFieldInfo.getColumn();
        final String logicNotDeleteValue = logicDeleteFieldInfo.getLogicNotDeleteValue();
        valueSql.append(logicDeleteColum).append("=").append(logicNotDeleteValue);
        return valueSql.toString();
    }

    private String prepareWhereSqlForMysqlBatch(TableInfo tableInfo) {
        return "${ew.customSqlSegment}";
    }

}
