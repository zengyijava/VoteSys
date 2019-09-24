package com.yc.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.dao.BaseDAO;
import com.yc.dao.UserMapper;
import com.yc.dao.VoteMapper;
import com.yc.po.VotePO;
import com.yc.vo.VoteVO;

public class VoteTest {
	VoteMapper mapper=null;
	BaseDAO dao=new BaseDAO();
	SqlSession session =null;
	
	@Test
	public void testfindAll() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 VoteMapper mapper=session.getMapper(VoteMapper.class);
		 VotePO po=new VotePO();
		 List<VotePO> list=mapper.findAll();
		 for(VotePO p:list) {
			 System.out.println(p.getVid()+"\t"+p.getVname()+"\t"+p.getVtype());
		 }
		 
	 }
	
	@Test
	public void testfindVote() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 VoteMapper mapper=session.getMapper(VoteMapper.class);
		 VoteVO vo=new VoteVO();
		 List<VoteVO> list=mapper.findVote();
		 for(VoteVO v:list) {
			 System.out.println(v.getVid()+"\t"+v.getVname()+"\t"+v.getOpNum());
		 }
		 
	 }
	
	
}
