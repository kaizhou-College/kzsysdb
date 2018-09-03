package com.kz.kzsys.web.controller;


import com.kz.kzsys.mapper.KzUserMapper;
import com.kz.kzsys.model.KzUser;
import com.kz.kzsys.service.KzUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class KzUserController {
    @Autowired
    private KzUserServiceImpl kzUserServiceImpl;

    @RequestMapping("/listSingleton")
    public List<KzUser> findByName(String username){

        return kzUserServiceImpl.findByName(username);
    }

}
