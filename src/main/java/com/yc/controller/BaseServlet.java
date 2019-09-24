package com.yc.controller;



import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.util.LogUtil;

public class BaseServlet extends HttpServlet{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException {
		doGet(req,resp);
	}
	/*
	 * 灏嗗璞¤浆涓簀son瀛楃涓�
	 */
	public  void toPrintString(Object obj, HttpServletResponse resp) throws  IOException {
		
		Gson gson=new Gson();
		String info=gson.toJson(obj);
		resp.getWriter().print(info);
	}
	
	public  void toPrintString(Integer i, HttpServletResponse resp) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(i);
		resp.getWriter().print(info);
	}
	
	public  void toPrintString(String str, HttpServletResponse resp) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(str);
		resp.getWriter().print(info);
	}
	
	/*
	 * easyui鍒嗛〉json鏍煎紡鏁版嵁
	 */
	public  void toPrintString(Object obj, HttpServletResponse resp,int total) throws  IOException {
		Gson gson=new Gson();
		String info=gson.toJson(obj);
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"total\":"+total+",\"rows\":");
		sb.append(info);
		sb.append("}");
		System.out.println(sb.toString());
		resp.getWriter().print(sb.toString());
	}
	
	
	
	
	
	/*
	 * 瑙ｉ噴璇锋眰灏嗘暟鎹皝瑁呰鍒癹avaBean 瀵硅薄
	 */
	public <T> T parserRequestToObject(HttpServletRequest request,Class<T> cls) {
		T t=null;
		
		try {
			//鑾峰彇鎵�鏈夊睘鎬�
			Field[] fields=cls.getDeclaredFields();
			//鑾峰彇鎵�鏈夌殑鏂规硶
			Method[] methods=cls.getDeclaredMethods();
			//鏍规嵁cls鍒涘缓瀵硅薄
			t=cls.newInstance();
			String value=null;
			String fieldName=null;
			for(Field field:fields) {
				fieldName=field.getName();
				//鏍规嵁灞炴�у彇鍊� 椤甸潰鐨刵ame灞炴�у�煎繀椤诲拰javaBean瀵硅薄灞炴�у悕涓�鑷�
				value=request.getParameter(fieldName);
				//褰撻〉闈㈡病鏈変紶鍏ュ�肩殑鏃跺��
				if(null==value || "".equalsIgnoreCase(value)) {
					continue;
				}
				for(Method m:methods) {
					if(("set"+fieldName).equalsIgnoreCase(m.getName())){
						String paramType=m.getParameterTypes()[0].getName();
						System.out.println(paramType);
						if("java.lang.Integer".equals(paramType)) {
							m.invoke(t, Integer.parseInt(value));
						}else if("java.lang.Double".equals(paramType)) {
							m.invoke(t, Double.parseDouble(value));
						}else if("java.lang.Float".equals(paramType)) {
							m.invoke(t, Float.parseFloat(value));
						}else if("java.lang.String".equals(paramType)) {
							m.invoke(t,value);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.debug(e.getMessage());		
		}
		return t;		
	}
	

}
