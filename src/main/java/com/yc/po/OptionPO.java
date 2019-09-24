package com.yc.po;

import java.io.Serializable;

public class OptionPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6541410483374678444L;

	private Integer opid;
	private String vid;
	private String opname;
	private Integer views;
	private String usid;
	public Integer getOpid() {
		return opid;
	}
	public void setOpid(Integer opid) {
		this.opid = opid;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
