package com.kz.kzsys.service;

import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzScore;
import com.kz.kzsys.model.KzScoreQuery;

public interface KzScoreService extends IBaseService<KzScore, KzScoreQuery> {
    Long myInsertSelective(KzScore ks);
    Long myUpdateByPrimaryKeySelective(KzScore ks);
}
