package com.kz.kzsys.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.chan on 2018/8/31.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "front/index";
    }
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }


}
