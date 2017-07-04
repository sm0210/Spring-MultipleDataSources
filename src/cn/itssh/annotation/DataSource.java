package cn.itssh.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.itssh.aspect.DataSourceAspect;

/**
 * @ClassName: DataSource.java
 * @Description: 多数据源注解(主要用于垂直分库，单库事务)
 * @author: SM(sm0210@qq.com)
 * @date: 2017年6月26日 下午2:23:23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource {
	
	/**
	 * @Title: value
	 * @Description: 数据源默认dataSource
	 * @return
	 */
	public String value() default DataSourceAspect.DEFAULT_DATASOURCE_NAME;
}
