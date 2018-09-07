package com.kz.kzsys.service;

import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzTremSummaryMapper;
import com.kz.kzsys.model.KzTremSummary;
import com.kz.kzsys.model.KzTremSummaryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KzTremSummaryServiceImpl extends BaseService<KzTremSummary, KzTremSummaryQuery> implements  KzTremSummaryService {

    private KzTremSummaryMapper kzTremSummaryMapper = null;
    @Autowired
    public void setDao(KzTremSummaryMapper mapper) {
        this.kzTremSummaryMapper = mapper;
        super.setMapper(mapper);
    }
    public Long myUpdateByPrimaryKeySelective(KzTremSummary kts){
        long l=kzTremSummaryMapper.myUpdateByPrimaryKeySelective(kts);
        return l;
    }


}
