package com.yc.biz.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yc.biz.IOptionBiz;
import com.yc.biz.IVoteBiz;
import com.yc.dao.BaseDAO;
import com.yc.dao.VoteMapper;
import com.yc.po.OptionPO;
import com.yc.po.VotePO;
import com.yc.vo.VoteVO;

public class VoteBizImpl implements IVoteBiz{
	BaseDAO dao=new BaseDAO();
	VoteMapper mapper=null;
	SqlSession session=null;

	@Override
	public List<VotePO> findAll() throws Exception {
		session=dao.getSqlSession(true);
		mapper=session.getMapper(VoteMapper.class);
		return mapper.findAll();
	}

	@Override
	public int addVote(VotePO po, String[] options) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VoteVO> findVote() throws Exception {
		session=dao.getSqlSession(true);
		mapper=session.getMapper(VoteMapper.class);
		List<VoteVO> list=mapper.findVote();
		for(VoteVO vo:list) {
			int num=totalVoteNum(vo.getVid());
			vo.setUserNum(num);
		}
		return list;
	}

	@Override
	public int totalVoteNum(String vid) throws Exception {
		IOptionBiz biz=new OptionBizImpl();
		List<OptionPO> list=biz.findByVid(vid);
		//创建set存储用户id
				Set<String> set=new HashSet<String>();
				for(OptionPO po:list) {
					String usid=po.getUsid();
					if(null==usid  || "".equals(usid)) {
						continue;
					}
					String []infos=usid.split(",");
					if(null==infos || usid.length()<=0) {
						continue;
					}
					for(String s:infos) {
						set.add(s);
					}
				}
				return set.size();
			}

}
