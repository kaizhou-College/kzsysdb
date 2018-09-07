package com.kz.kzsys.core.service;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.web.BaseQueryModel;

public interface IBaseService<M,QM extends BaseQueryModel> {

	public Long deleteByPrimaryKey(Serializable uuid);

	public Long insert(M m);

	public Long insertSelective(M m);

	public M selectByPrimaryKey(Serializable uuid);

	public Long updateByPrimaryKeySelective(M m);

	public Long updateByPrimaryKey(M m);

	public PageInfo<M> getByConditionPage(QM qm);

}
