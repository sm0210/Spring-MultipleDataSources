package cn.itssh.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DynamicDataSource.java
 * @Description: 动态设置多数据源
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:10:09
 * @blog: http://www.itssh.cn/
 */
public class DynamicDataSource extends AbstractRoutingDataSource  {

	/**
	 * 多数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		//
		return DataSourceContextHolder.getDataSource();
	}

}
