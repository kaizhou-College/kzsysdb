package com.kz.kzsys.service;

import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzClassMapper;
import com.kz.kzsys.mapper.KzDailySummaryMapper;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.model.KzDailySummary;
import com.kz.kzsys.model.KzDailySummaryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KzDailySummaryServiceImpl  extends BaseService<KzDailySummary, KzDailySummaryQuery> implements KzDailySummaryService  {

    private KzDailySummaryMapper kzDailySummaryMapper = null;
    @Autowired
    public void setDao(KzDailySummaryMapper mapper) {
        this.kzDailySummaryMapper = mapper;
        super.setMapper(mapper);
    }

    public Long myUpdateByPrimaryKeySelective(KzDailySummary kds){
        long l=kzDailySummaryMapper.myUpdateByPrimaryKeySelective(kds);
        return l;
    }
}
