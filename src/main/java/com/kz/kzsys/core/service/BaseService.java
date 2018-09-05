package com.kz.kzsys.core.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.exception.CustomException;
import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.core.web.BaseQueryModel;

public class BaseService<M, QM extends BaseQueryModel> implements IBaseService<M,QM> {
	private BaseMapper mapper = null;
	public void setMapper(BaseMapper mapper){
		this.mapper = mapper;
	}
	public PageInfo<M> getByConditionPage(QM qm) {
		PageHelper.startPage(qm.getPage(),qm.getLimit());
		List<M> list = mapper.getByConditionPage(qm);
		for(M m :list){
			System.out.println(m);
		}
		PageInfo<M> result = new PageInfo<M>(list);
		return result;
	}
	@Override
	public Long deleteByPrimaryKey(Serializable uuid) {
		return mapper.deleteByPrimaryKey(uuid);
	}
	@Override
	public Long insert(M m) {
		if(mapper==null){

			throw new CustomException(500,"");
		}
		return mapper.insert(m);
	}
	@Override
	public Long insertSelective(M m) {
		return mapper.insertSelective(m);
	}
	@Override
	public M selectByPrimaryKey(Serializable uuid) {
		return (M) mapper.selectByPrimaryKey(uuid);
	}
	@Override
	public Long updateByPrimaryKeySelective(M m) {
		return mapper.updateByPrimaryKey(m);
	}
	@Override
	public Long updateByPrimaryKey(M m) {
		return mapper.updateByPrimaryKey(m);
	}
}
