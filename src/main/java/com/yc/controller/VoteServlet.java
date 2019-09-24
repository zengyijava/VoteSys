package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.IVoteBiz;
import com.yc.biz.impl.VoteBizImpl;
import com.yc.po.VotePO;
import com.yc.vo.VoteVO;
@WebServlet("/vote.action")
public class VoteServlet extends BaseServlet{
	IVoteBiz biz=new VoteBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op=request.getParameter("op");
		if("addVote".equals(op)) {
			doAddVote(request,response);
		}else if("findVote".equals(op)){
			doFindVote(request,response);
		}
	}

	private void doFindVote(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<VoteVO> list=biz.findVote();
			toPrintString(list,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doAddVote(HttpServletRequest request, HttpServletResponse response) {
		String vname=request.getParameter("vname");
		String vtype=request.getParameter("vtype");
		String []options=request.getParameterValues("options");
		VotePO po=new VotePO();
		po.setVtype(Integer.parseInt(vtype));
		po.setVname(vname);
		try {
			int i=biz.addVote(po, options);
			if(i>0) {
				response.sendRedirect("manage.jsp");
			}else {
				response.sendRedirect("add.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
