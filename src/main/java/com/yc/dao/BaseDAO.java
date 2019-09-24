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
			
			//���������ļ�
			 inputStream=Resources.getResourceAsStream("mybatis-config.xml");
			//����sqlsessionfactory
			 factory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	 //��ȡ�Ự����
	 public SqlSession getSqlSession(boolean flag) {
		 return factory.openSession(flag); //falg true �����Զ��ύ
	 }
	 
	 public void closeAll(SqlSession session) {
		 session.close();
	 }

}
