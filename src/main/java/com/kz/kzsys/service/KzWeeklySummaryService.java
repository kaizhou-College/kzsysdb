package com.kz.kzsys.service;

import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzWeeklySummary;
import com.kz.kzsys.model.KzWeeklySummaryQuery;

public interface KzWeeklySummaryService extends IBaseService<KzWeeklySummary  , KzWeeklySummaryQuery> {
    Long myUpdateByPrimaryKeySelective(KzWeeklySummary kws);

}
