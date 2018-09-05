package com.kz.kzsys.service;


import com.kz.kzsys.mapper.KzUserMapper;
import com.kz.kzsys.model.KzUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class KzUserServiceImpl implements KzUserService {
    @Autowired
    private KzUserMapper kzUserMapper;

    @Override
    public List<KzUser> findByName(String username) {
        return null;
    }
}
