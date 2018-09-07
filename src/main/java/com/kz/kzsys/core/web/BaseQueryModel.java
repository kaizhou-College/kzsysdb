package com.kz.kzsys.core.web;


public class BaseQueryModel{

	private String queryJsonStr = "";
	private int page = 1;
	private int limit = 2;
	public String getQueryJsonStr() {
		return queryJsonStr;
	}
	public void setQueryJsonStr(String queryJsonStr) {
		this.queryJsonStr = queryJsonStr;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "BaseWebModel [queryJsonStr=" + queryJsonStr + ", page=" + page + ", limit=" + limit + "]";
	}

}
