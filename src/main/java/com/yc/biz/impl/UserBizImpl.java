package com.yc.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.biz.IUserBiz;
import com.yc.dao.BaseDAO;
import com.yc.dao.UserMapper;
import com.yc.po.UserPO;

public class UserBizImpl implements IUserBiz{
	UserMapper mapper=null;
	BaseDAO dao=new BaseDAO();
	SqlSession session =null;

	@Override
	public int register(UserPO po) throws Exception {
		int i=0;
		 session=dao.getSqlSession(true);   //默认是手动提交
		 mapper=session.getMapper(UserMapper.class);
		 i=mapper.register(po);
		 
		 dao.closeAll(session);
		 return i;
	}
	

	@Override
	public UserPO login(UserPO po) throws Exception {
		 UserPO p=null;
		 session=dao.getSqlSession(true);   //默认是手动提交
		 mapper=session.getMapper(UserMapper.class);
		 p=mapper.login(po);
		 
		 dao.closeAll(session);
		 return p;
	}

	@Override
	public List<UserPO> find(UserPO po) throws Exception {
		List<UserPO> list=null;
		 session=dao.getSqlSession(true);   //默认是手动提交
		 mapper=session.getMapper(UserMapper.class);
		 list=mapper.find(po);
		 
		 dao.closeAll(session);
		 return list;
	}

}
