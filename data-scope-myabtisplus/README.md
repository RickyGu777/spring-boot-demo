依赖 aspect 和 mybatis-plus 的数据权限实现

使用时在方法上添加注释 `@DataScope` 即可开启数据权限，可以使用 `deptAlias、deptField、userAlias、userField` 来指定表别名和数据字段

如果是分页查询，则需要添加 `pageable` 参数，如 `@DataScope(pageable = true)`

数据权限默认只对第一次查询生效，可添加配置 `mybatis-plus.dataScope.oncePolicy: false` 使得数据权限在切面中一直生效

也可以直接调用 `DataScopeSwitch.open()` 或 `DataScopeSwitch.close()` 手动打开或关闭数据权限，也可以使用 `DataScopeSwitch.openOnce()` 开启单次数据权限

注意：若想与若依原来的数据权限共存且互不干扰，只需更改原来的数据权限注解，使得两个数据权限的实现使用不同注解即可。

注意：持久化对象和编写的xml中不能出现关键字，若依框架部门中的 query 字段，就是关键字。

参考：
1. [若依-数据权限](http://doc.ruoyi.vip/ruoyi/document/htsc.html#%E6%95%B0%E6%8D%AE%E6%9D%83%E9%99%90)
2. [Mybatis-plus数据权限DataPermissionInterceptor实现](https://blog.csdn.net/qq_42445433/article/details/124406475)
3. [Mybatis-Plus通过注解形式实现数据权限过滤](https://blog.csdn.net/u011584350/article/details/118968300)
4. [从零搭建开发脚手架 基于Mybatis-Plus的数据权限实现](https://juejin.cn/post/6950163802067304478)