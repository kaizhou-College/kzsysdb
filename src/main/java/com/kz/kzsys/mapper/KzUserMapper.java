package com.kz.kzsys.mapper;


import com.kz.kzsys.model.KzUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KzUserMapper {
    /**
    * @Description: 根据用户名查询用户信息
    * @param username 用户名
    * @return  查询结果
    * @author 凯舟.陈超
    * @date 2018/8/17 8:52
    */
    //TODO 需要数据库kz_user表上的username字段建立一个唯一索引《完成》
    KzUser findByName(String username);
}
