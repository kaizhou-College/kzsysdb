package com.kz.kzsys.service;

import com.kz.kzsys.core.page.PageInfo;
import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.model.KzDailySummary;
import com.kz.kzsys.model.KzDailySummaryQuery;

public interface KzDailySummaryService  extends IBaseService<KzDailySummary, KzDailySummaryQuery>{
    Long myUpdateByPrimaryKeySelective(KzDailySummary kds);

}
