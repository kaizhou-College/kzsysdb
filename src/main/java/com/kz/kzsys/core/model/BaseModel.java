package com.kz.kzsys.core.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@SuppressWarnings("serial")
public class BaseModel implements java.io.Serializable{
	@JsonIgnore
	private Long uuid;
	/*@JsonIgnore
	private int pageNum;
	@JsonIgnore
	private int pageSize;

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
	}*/
	/*public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
}
