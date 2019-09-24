package com.yc.dao;

import java.util.List;

import com.yc.po.VotePO;
import com.yc.vo.VoteVO;

public interface VoteMapper {
	public List<VotePO> findAll() throws Exception;
	
	public int addVote(VotePO po, String[] options) throws Exception;
	
	public List<VoteVO> findVote() throws Exception;
	
	public int totalVoteNum(String vid) throws Exception;
	
	

}
