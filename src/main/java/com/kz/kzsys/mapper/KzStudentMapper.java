package com.kz.kzsys.mapper;

import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.model.KzScore;
import com.kz.kzsys.model.KzScoreQuery;
import com.kz.kzsys.model.KzStudent;
import com.kz.kzsys.model.KzStudentQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KzStudentMapper extends BaseMapper<KzStudent, KzStudentQuery> {

    KzStudent selectByPrimaryName(String name);
    List<KzStudent> selectByPrimaryLiveName(KzScoreQuery kq);

}