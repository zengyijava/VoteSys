package com.yc.biz;

import java.util.List;

import com.yc.po.OptionPO;
import com.yc.vo.OptionVO;

public interface IOptionBiz {
public OptionPO findByOpid(int opid) throws Exception;
	
	public int partVote(String[] opids, int uid) throws Exception;
	
	public List<OptionPO> findByVid(String vid) throws Exception;
	
	public List<OptionVO> findVOByVid(String vid) throws Exception;
	
	public int updateViews(String [] options) throws Exception;
	

}
