package cn.itssh.test;

import java.util.List;
import java.util.Map;

import cn.itssh.dao.DataSourceDao;
import cn.itssh.utils.SpringBeanHelper;

/**
 * @ClassName: TestDataSource.java
 * @Description: 多数据源测试
 * @author: SM(sm0210@qq.com)
 * @date: 2017年7月4日 上午9:08:33
 * @blog: http://www.itssh.cn/
 */
public class TestDataSource {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//测试多数据源
		testDataSource();
	}
	
	/**
	 * 测试数据源
	 */
	public static void testDataSource(){
		//
		DataSourceDao dataSourceDao = (DataSourceDao)SpringBeanHelper.getBean("dataSourceDaoImpl");
		//第一个数据源
		try {
			//
			List<Map<String, Object>> list = dataSourceDao.queryList();
			//
			System.out.println("数据源1 总记录数："+list.size() + "条，查询到的数据为：");
			//
			System.out.println(list);
			//
			//查询数据源2
			list = dataSourceDao.queryList2();
			//
			System.out.println("数据源2 总记录数："+list.size() + "条，查询到的数据为：");
			//
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println("查询失败...." + e.getMessage());
		}
	}

}
