package com.kz.kzsys.mapper;

import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.model.KzTremSummary;
import com.kz.kzsys.model.KzTremSummaryQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KzTremSummaryMapper extends BaseMapper<KzTremSummary, KzTremSummaryQuery> {
    Long myUpdateByPrimaryKeySelective(KzTremSummary kts);
}