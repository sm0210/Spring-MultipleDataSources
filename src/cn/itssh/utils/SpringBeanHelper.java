package cn.itssh.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: ServiceHelper.java
 * @Description: Spring Bean辅助类
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:10:37
 * @blog: http://www.itssh.cn/
 */
public class SpringBeanHelper {
	
	/**
	 * 通过classpath获取
	 * @param className
	 * @return
	 */
	@SuppressWarnings("resource")
	public static Object getBean(String className){
		//加载Spring 上下文
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "application*.xml" });
		//返回Beand对象
		return  ctx.getBean(className);
	}	
	/**
	 * @Title: getAnnotation
	 * @Description: 返回注解
	 * @param method
	 * @param annotationType
	 * @return <A extends Annotation>
	 */
	public static <A extends Annotation> A getAnnotation(Method method, Class<A> annotationType) {
		@SuppressWarnings("unchecked")
		boolean hasAnnotation = SpringBeanHelper.hasAnnotation(method, annotationType);
		if(hasAnnotation){
			return method.getAnnotation(annotationType);
		}
		else{
			return null;
		}
	}
	
	/**
	 * @Title: hasAnnotation
	 * @Description: 是否存在指定注解
	 * @param method
	 * @param annotationType
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public static boolean hasAnnotation(Method method, Class<? extends Annotation>... annotationTypes){
		for(Class<? extends Annotation> annotationType : annotationTypes){
			if(method.isAnnotationPresent(annotationType)){
				return true;
			}
		}
		return false;
	}
	
}
