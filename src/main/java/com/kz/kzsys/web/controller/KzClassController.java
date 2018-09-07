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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }
    @RequestMapping("/edit")
    public ModelAndView edit(Long id,HttpServletRequest request){
        KzClass kzClass =kzClassService.selectByPrimaryKey(id);

        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("/front/edit_class");
        view.addObject("kzClass", kzClass);
        return view;
    }
    @PostMapping("/editSubmit")
    @ResponseBody
    public ServerResponse<String> editSubmit(KzClass kzClass){
        Long result = kzClassService.updateByPrimaryKeySelective(kzClass);

        return ServerResponse.createBySuccess("更新成功");
    }



}
