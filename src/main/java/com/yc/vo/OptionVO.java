package com.yc.vo;

import java.io.Serializable;
import java.sql.Date;

public class OptionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vname;
	private Integer vtype;
	private String startDate;
	private String endDate;
	
	private Integer opid;
	private String vid;
	private String opname;
	private Integer views;
	private String usid;
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public Integer getVtype() {
		return vtype;
	}
	public void setVtype(Integer vtype) {
		this.vtype = vtype;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
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
