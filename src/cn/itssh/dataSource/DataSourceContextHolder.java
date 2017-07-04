package cn.itssh.dataSource;
/**
 * @ClassName: DataSourceContextHolder.java
 * @Description: 多数据源线程类
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:09:51
 * @blog: http://www.itssh.cn/
 */
public class DataSourceContextHolder {

	//
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	/**
	 * 
	 * @param dataSource
	 */
	public static void setDataSource(String dataSource) {  
        contextHolder.set(dataSource);  
    }  
  
	/**
	 * @return
	 */
    public static String getDataSource() {  
        return ((String) contextHolder.get());  
    }  
  
    /**
     */
    public static void clearDataSource() {  
        contextHolder.remove();  
    }  
}
