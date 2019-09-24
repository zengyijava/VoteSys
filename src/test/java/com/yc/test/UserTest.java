package com.yc.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.dao.BaseDAO;
import com.yc.dao.UserMapper;
import com.yc.po.UserPO;

 public class UserTest {
	UserMapper mapper=null;
	BaseDAO dao=new BaseDAO();
	SqlSession session =null;
	
	
	@Test
	public void testRegister() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 UserMapper mapper=session.getMapper(UserMapper.class);
		 UserPO po=new UserPO();
		 po.setUname("zhangsan");
		 po.setPwd("a");
		 mapper.register(po);
		 System.out.println(po.getUname());
		 
	 }
	
	@Test
	public void testLogin() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 UserMapper mapper=session.getMapper(UserMapper.class);
		 UserPO po=new UserPO();
		 po.setUname("yc");
		 po.setPwd("a");
		 mapper.login(po);
		 System.out.println(po.getUname());
		 
	 }
	
	@Test
	public void testFind() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 UserMapper mapper=session.getMapper(UserMapper.class);
		 UserPO po=new UserPO();
		 po.setUsid(1);
		 List<UserPO> list=mapper.find(po);
		 for(UserPO p:list) {
			 System.out.println(p.getUname()+"\t"+p.getPwd());
		 }
		 
		 
	 }
	
	
	
	
	
	

}
