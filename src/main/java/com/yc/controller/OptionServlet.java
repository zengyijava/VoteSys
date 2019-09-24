package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.IOptionBiz;
import com.yc.biz.IVoteBiz;
import com.yc.biz.impl.OptionBizImpl;
import com.yc.biz.impl.VoteBizImpl;
import com.yc.vo.OptionVO;
@WebServlet("/option.action")
public class OptionServlet extends BaseServlet{
	IOptionBiz obiz=new OptionBizImpl();
	IVoteBiz vbiz=new VoteBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op=request.getParameter("op");
		if("findByVid".equals(op)) {
			doFindByVid(request,response);
		}else if("findVOByVid".equals(op)){
			doFindVOByVid(request,response);
		}else if("updateViews".equals(op)) {
			doUpdateViews(request,response);
			
		}
	}

	private void doUpdateViews(HttpServletRequest request, HttpServletResponse response) {
		String options[]=request.getParameterValues("options");
		try {
			int i=obiz.updateViews(options);
			if(i>0) {
				response.sendRedirect("manage.jsp");
			}else {
				response.sendRedirect("vote.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doFindVOByVid(HttpServletRequest request, HttpServletResponse response) {
		String vid=request.getParameter("vid");
		try {
			List<OptionVO> list=obiz.findVOByVid(vid);
			int num=vbiz.totalVoteNum(vid);
			//´æ´¢ÔÚrequest
			request.setAttribute("ops", list);
			request.setAttribute("userNum", num);
			request.getRequestDispatcher("vote.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doFindByVid(HttpServletRequest request, HttpServletResponse response) {
		String vid=request.getParameter("vid");
		try {
			List<OptionVO> list=obiz.findVOByVid(vid);
			int num=vbiz.totalVoteNum(vid);
			//´æ´¢ÔÚrequest
			request.setAttribute("ops", list);
			request.setAttribute("userNum", num);
			request.getRequestDispatcher("view.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
