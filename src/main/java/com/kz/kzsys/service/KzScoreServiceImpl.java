package com.kz.kzsys.service;

import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzClassMapper;
import com.kz.kzsys.mapper.KzScoreMapper;
import com.kz.kzsys.mapper.KzStudentMapper;
import com.kz.kzsys.model.KzScore;
import com.kz.kzsys.model.KzScoreQuery;
import com.kz.kzsys.model.KzStudent;
import com.kz.kzsys.service.KzScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class KzScoreServiceImpl extends BaseService<KzScore, KzScoreQuery> implements KzScoreService {
    @Autowired
    private KzStudentMapper ksM;

    private KzScoreMapper kzScoreMapper = null;
    @Autowired
    public void setDao(KzScoreMapper mapper) {
        this.kzScoreMapper = mapper;
        super.setMapper(mapper);
    }
    public  Long myInsertSelective(KzScore ks){
        if(ks!=null){//我需要按照我穿进来的那么查找stuid
            KzStudent result= ksM.selectByPrimaryName(ks.getStuName());
            ks.setStuid(result.getSid());
        }
        ks.setCreateTime(new Date());
        long l=kzScoreMapper.insertSelective(ks);
        return l;
    }
    public Long myUpdateByPrimaryKeySelective(KzScore ks){
        ks.setUpdateTime(new Date());
        long l=kzScoreMapper.myUpdateByPrimaryKeySelective(ks);
        return 1L;
    }

}
