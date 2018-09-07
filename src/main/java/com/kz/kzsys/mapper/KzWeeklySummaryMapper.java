package com.kz.kzsys.mapper;

import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.model.KzWeeklySummary;
import com.kz.kzsys.model.KzWeeklySummaryQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KzWeeklySummaryMapper extends BaseMapper<KzWeeklySummary , KzWeeklySummaryQuery> {
    Long myUpdateByPrimaryKeySelective(KzWeeklySummary kws);
}