package com.kz.kzsys.mapper;


import com.kz.kzsys.core.mapper.BaseMapper;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KzClassMapper extends BaseMapper<KzClass,KzClassQuery>{
    KzClass selectByPrimaryName(String name);

}
