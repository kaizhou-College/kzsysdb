package com.kz.kzsys.service;


import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzClassMapper;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KzClassServiceImpl extends BaseService<KzClass,KzClassQuery> implements KzClassService {
    private KzClassMapper kzClassMapper = null;
    @Autowired
    public void setDao(KzClassMapper mapper) {
        this.kzClassMapper = mapper;
        super.setMapper(mapper);
    }
}
