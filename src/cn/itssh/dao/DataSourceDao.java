package cn.itssh.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DataSourceDao.java
 * @Description: 多数据源Dao
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:08:51
 * @blog: http://www.itssh.cn/
 */
public interface DataSourceDao {
	
	/**
	 * 查询数据源1
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryList() throws Exception;
	/**
	 * 查询数据源2
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryList2() throws Exception;
}
