package cn.itssh.aspect;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.itssh.annotation.DataSource;
import cn.itssh.dataSource.DataSourceContextHolder;
import cn.itssh.utils.SpringBeanHelper;

/**
 * @ClassName: DataSourceAspect.java
 * @Description: 多数据源切面
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:31:00
 * @blog: http://www.itssh.cn/
 */
public class DataSourceAspect {
	
	/**
	 * 日志
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 构造方法
	 */
	public DataSourceAspect() {}
	
	/**
	 * @FieldName: DEFAULT_DATASOURCE_NAME
	 * @FieldType: String
	 * @Description: 默认数据源名称
	 */
	public static final String DEFAULT_DATASOURCE_NAME = "dataSource";
	/**
	 * 通过aop动态设置多数据源
	 * @param jp
	 */
	public void beforeDataSource(JoinPoint jp){
		//
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		//
		logger.debug("设置动态数据源的目标方法：" + jp.getTarget().getClass().getName() + "." + methodSignature.getMethod().getName());
		//
		DataSource dataSource = SpringBeanHelper.getAnnotation(methodSignature.getMethod(), DataSource.class);
		//默认dataSource数据源
		String ds = DataSourceAspect.DEFAULT_DATASOURCE_NAME;
		//如果方法注解了数据源
		if(StringUtils.isNotEmpty(ObjectUtils.toString(dataSource))){
			//
			ds = dataSource.value();
		}
		
		//设置动态数据源
		DataSourceContextHolder.setDataSource(ds);
		//
		logger.debug("动态设置数据源["+  ds +"]成功：");
	}
	
	/**
	 * 清空据源线程变量
	 */
	public void afterDataSource(){
		//清空据源线程变量 
		DataSourceContextHolder.clearDataSource();
	}
}
