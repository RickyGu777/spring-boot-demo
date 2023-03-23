package com.gurenkai.demo.infrastructure.config.mp;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import java.util.List;

/**
 * @author gu_renkai
 * @date 2022/12/6 10:55
 */
public class EasySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new RecoverByPkMethod());
        methodList.add(new RecoverByWrapperMethod());
        methodList.add(new PhysicalDeleteByPkMethod());
        return methodList;
    }

}
