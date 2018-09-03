package com.kz.kzsys.web.controller;

import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.core.exception.CustomException;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.service.KzClassService;
import javafx.print.PageOrientation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//为什么这里不能用RectController
@Controller
@RequestMapping("/class")
public class KzClassController {
    @Autowired
    private KzClassService kzClassService;

    @RequestMapping("/index")
    public String index(){
        return "/front/list_classes";
    }

    @RequestMapping("/add")
    public String add(){
        return "/front/add_class";
    }

    @PostMapping("/addSubmit")
    @ResponseBody
    public ServerResponse addSubmit(KzClass kzClass){
        Long classId = kzClassService.insert(kzClass);
        if(classId<=0){
            throw new CustomException(500,"添加失败");
    }
        return ServerResponse.createBySuccess();

    }


    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzClassQuery kcQ){
        PageInfo<KzClass> pageInfo = kzClassService.getByConditionPage(kcQ);
        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getSize());
    }

}
