package com.kz.kzsys.core.mapper;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<M, QM> {
	public Long deleteByPrimaryKey(Serializable uuid);

	public Long insert(M m);

	public Long insertSelective(M m);

	public M selectByPrimaryKey(Serializable uuid);

	public Long updateByPrimaryKeySelective(M m);

	public Long updateByPrimaryKey(M m);

	public  List<M> getByConditionPage(QM qm);
}
