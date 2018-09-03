package com.kz.kzsys.core.web;


public class BaseQueryModel{
	
	private String queryJsonStr = "";
	private int pageNum = 1;
	private int pageSize = 2;
	public String getQueryJsonStr() {
		return queryJsonStr;
	}
	public void setQueryJsonStr(String queryJsonStr) {
		this.queryJsonStr = queryJsonStr;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "BaseWebModel [queryJsonStr=" + queryJsonStr + ", pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
	
}
