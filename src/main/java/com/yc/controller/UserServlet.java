package com.yc.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.IUserBiz;
import com.yc.biz.impl.UserBizImpl;
import com.yc.po.UserPO;
import com.yc.util.LogUtil;

@WebServlet("/user.action")
public class UserServlet extends BaseServlet{
	IUserBiz biz=new UserBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op=request.getParameter("op");
		if("login".equals(op)) {
			doLogin(request,response);
		}else if("register".equals(op)){
			doRegister(request,response);
		}
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		UserPO po=new UserPO();
		po.setPwd(pwd);
		po.setUname(uname);
		int result;
		try {
			result = biz.register(po);
			if(result>0 && uname!=null && pwd!=null) {
				response.sendRedirect("login.jsp");
			}else {
				response.sendRedirect("register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug("µÇÂ¼Ê§°Ü..."+e.getMessage());
		}
		
	}
		

	private void doLogin(HttpServletRequest request, HttpServletResponse response) {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		UserPO po=new UserPO();
		po.setPwd(pwd);
		po.setUname(uname);
		try {
			UserPO user=biz.login(po);
			if(null==user) {
				response.sendRedirect("login.jsp");
			}else {
				ServletContext context=request.getServletContext();
				Integer count=(Integer)context.getAttribute("userCount");
				if(count==null) {
					count=1;
				}else {
					count++;
				}
				context.setAttribute("userCount", count);
				LogUtil.log.info(uname+"ç™»å½•æˆåŠŸ");
				request.getSession().setAttribute("user", user);
				response.sendRedirect("manage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug("µÇÂ¼Ê§°Ü..."+e.getMessage());
		}
		
	}
	
	
	

}
