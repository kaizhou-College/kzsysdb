package com.kz.kzsys.service;


import com.kz.kzsys.model.KzUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KzUserService {
    List<KzUser> findByName(String username);
}
