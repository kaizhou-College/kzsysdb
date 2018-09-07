package com.kz.kzsys.service;


import com.kz.kzsys.core.service.BaseService;
import com.kz.kzsys.mapper.KzClassMapper;
import com.kz.kzsys.mapper.KzStudentMapper;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzScoreQuery;
import com.kz.kzsys.model.KzStudent;
import com.kz.kzsys.model.KzStudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KzStudentServiceImpl  extends BaseService<KzStudent, KzStudentQuery> implements KzStudentService{
    @Autowired
    private KzClassMapper kcM;

    private KzStudentMapper kzStudentMapper = null;
    @Autowired
    public void setDao(KzStudentMapper mapper) {
        this.kzStudentMapper = mapper;
        super.setMapper(mapper);
    }

    public Long myInsertSelective(KzStudent ks){
        //这个的添加时 因为需要添加班级id 但传进来的数据是班级名称 所以这里这里需要先查询班级名称
        KzClass cla= setByClassName(ks.getClassName());
        if(cla!=null){
            ks.setClassid(cla.getId());
        }
        long result=kzStudentMapper.insertSelective(ks);
        return result;
    }

    public Long myUpdateByPrimaryKeySelective(KzStudent ks){
        //这个的添加时 因为需要添加班级id 但传进来的数据是班级名称 所以这里这里需要先查询班级名称
        KzClass cla= setByClassName(ks.getClassName());
        if(cla!=null){
            ks.setClassid(cla.getId());
        }
        long result=kzStudentMapper.updateByPrimaryKeySelective(ks);
        return result;
    }

    public KzClass setByClassName(String name){
        KzClass cla= kcM.selectByPrimaryName(name);
        System.out.print(name+"=======");
        return cla;
    }

    public List<KzStudent> selectByPrimaryLiveName(KzScoreQuery kq){
        List<KzStudent> stu=kzStudentMapper.selectByPrimaryLiveName(kq);
        return stu;
    }

}
