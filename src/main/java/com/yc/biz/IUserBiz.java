package com.yc.biz;

import java.util.List;

import com.yc.po.UserPO;

public interface IUserBiz {
public int register(UserPO po) throws Exception;
	
	
	public UserPO login(UserPO po) throws Exception;
	
	
	public List<UserPO> find(UserPO po) throws Exception;

}
