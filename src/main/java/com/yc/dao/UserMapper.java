package com.yc.dao;

import java.util.List;

import com.yc.po.UserPO;

public interface UserMapper {
	public int register(UserPO po) throws Exception;
	
	
	public UserPO login(UserPO po) throws Exception;
	
	
	public List<UserPO> find(UserPO po) throws Exception;
	
	
	

}
