package com.yc.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.biz.IOptionBiz;
import com.yc.dao.BaseDAO;
import com.yc.dao.OptionMapper;
import com.yc.po.OptionPO;
import com.yc.vo.OptionVO;

public class OptionBizImpl implements IOptionBiz{
	BaseDAO dao=new BaseDAO();
	SqlSession session=null;
	OptionMapper mapper=null;

	@Override
	public OptionPO findByOpid(int opid) throws Exception {
		
		return null;
	}

	@Override
	public int partVote(String[] opids, int uid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OptionPO> findByVid(String vid) throws Exception {
		session=dao.getSqlSession(true);
		mapper=session.getMapper(OptionMapper.class);
		return mapper.findByVid(vid);
	}

	@Override
	public List<OptionVO> findVOByVid(String vid) throws Exception {
		session=dao.getSqlSession(true);
		mapper=session.getMapper(OptionMapper.class);
		return mapper.findVOByVid(vid);
	}

	@Override
	public int updateViews(String[] options) throws Exception {
		session=dao.getSqlSession(true);
		mapper=session.getMapper(OptionMapper.class);
		return mapper.updateViews(options);
	}

}
