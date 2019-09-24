package com.yc.vo;

import java.io.Serializable;

public class VoteVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vid;//主题编号
	private String vname;//主题名称
	private Integer vtype;//主题类型
	private String startDate;
	private String endDate;
	private Long opNum;//选项个数
	private Integer userNum;//参与投票的人�?
	
	public Integer getUserNum() {
		return userNum;
	}
	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
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
	public Long getOpNum() {
		return opNum;
	}
	public void setOpNum(Long opNum) {
		this.opNum = opNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
