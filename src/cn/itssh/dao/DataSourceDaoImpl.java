package cn.itssh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.itssh.annotation.DataSource;
import cn.itssh.dataSource.DataSourceContextHolder;

/**
 * @ClassName: DataSourceDaoImpl.java
 * @Description: 多数据源dao实现
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:09:07
 * @blog: http://www.itssh.cn/
 */
@Component
@Transactional
public class DataSourceDaoImpl extends NamedParameterJdbcDaoSupport implements DataSourceDao {

	/**
	 * 查询数据源1
	 */
	@DataSource(value="dataSource1")
	public List<Map<String, Object>> queryList() throws Exception {
		//
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//
		StringBuffer sb = new StringBuffer("select id,name from demo_table1");
		//
		RowMapper<Map<String, Object>> map = null;
		//
		//默认查询第一个数据源
		map = new RowMapper<Map<String, Object>>(){
			//
			public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", rs.getString("ID"));
				params.put("name", rs.getString("NAME"));
				//
				return params;
			}
		};
		
		//
		list = this.getJdbcTemplate().query(sb.toString(), map);
		//
		return list;
	}
	
	/**
	 * 查询数据源2
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@DataSource(value="dataSource2")
	public List<Map<String, Object>> queryList2() throws Exception {
		//
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//
		StringBuffer sb = new StringBuffer(" select id,name from student ");
		//
		RowMapper<Map<String, Object>> map = null;
		//
		//默认查询第一个数据源
		map = new RowMapper<Map<String, Object>>(){
			//
			public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", rs.getString("ID"));
				params.put("name", rs.getString("NAME"));
				//
				return params;
			}
		};
		
		//
		list = this.getJdbcTemplate().query(sb.toString(), map);
		//
		return list;
	}

}
