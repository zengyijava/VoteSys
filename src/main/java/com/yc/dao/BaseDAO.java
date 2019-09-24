package com.yc.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDAO {
	static SqlSessionFactory factory;
	 static  {
		 InputStream inputStream=null;
		 try {
			
			//加载配置文件
			 inputStream=Resources.getResourceAsStream("mybatis-config.xml");
			//创建sqlsessionfactory
			 factory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	 //获取会话对象
	 public SqlSession getSqlSession(boolean flag) {
		 return factory.openSession(flag); //falg true 事务自动提交
	 }
	 
	 public void closeAll(SqlSession session) {
		 session.close();
	 }

}
