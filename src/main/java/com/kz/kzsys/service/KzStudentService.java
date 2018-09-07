package com.kz.kzsys.service;

import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzScoreQuery;
import com.kz.kzsys.model.KzStudent;
import com.kz.kzsys.model.KzStudentQuery;

import java.util.List;

public interface KzStudentService  extends IBaseService<KzStudent, KzStudentQuery> {
    public Long myInsertSelective(KzStudent ks);
    public Long myUpdateByPrimaryKeySelective(KzStudent ks);
    List<KzStudent> selectByPrimaryLiveName(KzScoreQuery kq);


}
