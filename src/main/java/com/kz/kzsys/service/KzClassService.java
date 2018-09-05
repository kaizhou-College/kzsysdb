package com.kz.kzsys.service;


import com.kz.kzsys.core.service.IBaseService;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.model.KzUser;

import java.util.List;

public interface KzClassService extends IBaseService<KzClass,KzClassQuery> {
    KzUser login(String userName,String password);
}
