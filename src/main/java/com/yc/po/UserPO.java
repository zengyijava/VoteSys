package com.yc.po;

import java.io.Serializable;

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 71637022107728567L;
	private Integer usid;
	private String uname;
	private String pwd;
	public Integer getUsid() {
		return usid;
	}
	public void setUsid(Integer usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
