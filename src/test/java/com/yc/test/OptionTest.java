package com.yc.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.dao.BaseDAO;
import com.yc.dao.OptionMapper;
import com.yc.po.OptionPO;
import com.yc.vo.OptionVO;

public  class OptionTest {
	OptionMapper mapper=null;
	BaseDAO dao=new BaseDAO();
	SqlSession session =null;
	
	@Test
	public void testfindByVid() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 OptionMapper mapper=session.getMapper(OptionMapper.class);
		 OptionPO po=new OptionPO();
		 List<OptionPO> list=(List<OptionPO>) mapper.findByVid("1556950220781460");
		 for(OptionPO p:list) {
			 System.out.println(p.getVid()+"\t"+p.getOpname());
		 }
	 }
	
	
	@Test
	public void testfindVOByVid() throws Exception {
		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
		 OptionMapper mapper=session.getMapper(OptionMapper.class);
		 OptionVO po=new OptionVO();
		 List<OptionVO> list= mapper.findVOByVid("1556950220781460");
		 for(OptionVO p:list) {
			 System.out.println(p.getVid()+"\t"+p.getOpname());
		 }
	 }
	
//	@Test
//	public void testupdateViews() throws Exception {
//		 SqlSession session=dao.getSqlSession(true);   //默认是手动提交
//		 OptionMapper mapper=session.getMapper(OptionMapper.class);
//		 OptionVO vo=new OptionVO();
//		 vo.setOpname("广州");
//		 mapper.updateViews(vo);
//		 
//	 }
	
	
	

}
