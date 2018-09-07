package com.kz.kzsys.mapper;

import com.kz.kzsys.core.mapper.BaseMapper;

import com.kz.kzsys.model.KzScore;
import com.kz.kzsys.model.KzScoreQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KzScoreMapper  extends BaseMapper<KzScore, KzScoreQuery> {
    Long myUpdateByPrimaryKeySelective(KzScore ks);
}