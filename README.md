# Spring-MultipleDataSources
Spring多数据源 (http://www.itssh.cn/) 

简介：
 Spring默认连接数据库只提供了一个数据源，如果有多个数据源，可以在连接数据源之前动态改变数据源，
从而实现多数据源效果，本项目中提供了数据源注解接口(@DataSource) 使用时在dao层方法里注入数据源，适用于垂直分库,不支持分布式事务，事务只针对当前数据源,有问题请发邮件：sm0210@qq.com

## Dao注入数据源

![](https://github.com/sm0210/Spring-MultipleDataSources/blob/master/Spring-MultipleDataSources.jpg "Spring-MultipleDataSources")

 
 ###如果您觉得此文有帮助，可以打赏点钱给我支付宝sm0210@qq.com ，或扫描二维码
![](https://github.com/sm0210/SMCalendar/blob/master/sm0210%40qq.com.jpg "sm0210@qq.com")
