package com.kz.kzsys.mapper;
import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.model.KzDailySummary;
import com.kz.kzsys.model.KzDailySummaryQuery;
import com.kz.kzsys.model.KzScore;
import com.kz.kzsys.model.KzScoreQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KzDailySummaryMapper  extends BaseMapper<KzDailySummary, KzDailySummaryQuery> {
    Long myUpdateByPrimaryKeySelective(KzDailySummary kds);
}