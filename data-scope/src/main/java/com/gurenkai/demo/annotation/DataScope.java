package com.gurenkai.demo.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 部门表的别名
     */
    String deptAlias() default "";

    /**
     * 部门字段
     */
    String deptField() default "";

    /**
     * 用户表的别名
     */
    String userAlias() default "";

    /**
     * 用户字段
     */
    String userField() default "";
}
