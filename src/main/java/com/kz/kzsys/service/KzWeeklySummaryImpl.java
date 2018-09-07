package com.kz.kzsys.service;

import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzWeeklySummaryMapper;
import com.kz.kzsys.model.KzWeeklySummary;
import com.kz.kzsys.model.KzWeeklySummaryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KzWeeklySummaryImpl extends BaseService<KzWeeklySummary, KzWeeklySummaryQuery> implements KzWeeklySummaryService {
    private KzWeeklySummaryMapper kzWeeklySummaryMapper = null;
    @Autowired
    public void setDao(KzWeeklySummaryMapper mapper) {
        this.kzWeeklySummaryMapper = mapper;
        super.setMapper(mapper);
    }
    public Long myUpdateByPrimaryKeySelective(KzWeeklySummary kws){
        long l= kzWeeklySummaryMapper.myUpdateByPrimaryKeySelective(kws);
        return l;
    }

}
