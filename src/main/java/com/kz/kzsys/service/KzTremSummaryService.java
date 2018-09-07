package com.kz.kzsys.service;

import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzTremSummary;
import com.kz.kzsys.model.KzTremSummaryQuery;

public interface KzTremSummaryService extends IBaseService<KzTremSummary, KzTremSummaryQuery> {
    Long myUpdateByPrimaryKeySelective(KzTremSummary kts);
}
