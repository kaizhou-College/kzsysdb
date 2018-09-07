package com.kz.kzsys.web.controller;

import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.core.exception.CustomException;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.model.KzStudent;
import com.kz.kzsys.model.KzStudentQuery;
import com.kz.kzsys.service.KzClassService;
import com.kz.kzsys.service.KzStudentService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class KzStudentController {

    @Autowired
    private KzClassService kcsM;

    @Autowired
    private KzStudentService kzStudentService;

    @RequestMapping("/listStudent")
    public String listStudent(){
        return "/front/list_student";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "/front/add_student";
    }
    @RequestMapping("/toEditStudent")
    public ModelAndView toEditStudent(int sid, HttpServletRequest re){
        System.out.print(sid+"=============");
        KzStudent ks=kzStudentService.selectByPrimaryKey(sid);
        if(ks!=null) {//需要显示班级名称
            KzClass kc = kcsM.selectByPrimaryKey((long) ks.getClassid());
            ks.setClassName(kc.getClassName());
        }
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/front/edit_student");
        mv.addObject("kzStudent",ks);
        return mv;
    }
    @RequestMapping("/editStudent")
    @ResponseBody
    public ServerResponse<String> editStudent(KzStudent ks){
        long l=kzStudentService.myUpdateByPrimaryKeySelective(ks);
        if(l>=1){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }
    }
    @RequestMapping("/delStu")
    @ResponseBody
    public ServerResponse<String> delStu(int sid){
        long l=kzStudentService.deleteByPrimaryKey(sid);
        if(l>=1){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }

    }

    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzStudentQuery ksQ){//这个下面因为需要显示  class的名称 所以还需要一部查询
        PageInfo<KzStudent> pageInfo = kzStudentService.getByConditionPage(ksQ);
        List<KzStudent> data=pageInfo.getList();
        for(int i = 0 ;i < data.size();i++){
            System.out.println(data.get(i).getClassid());
            KzClass kc= kcsM.selectByPrimaryKey((long)data.get(i).getClassid());
            data.get(i).setClassName(kc.getClassName());
        }
        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }
    @PostMapping("/add")
    @ResponseBody
    public ServerResponse<String> addStu(KzStudent ks){

        long l=kzStudentService.myInsertSelective(ks);
        if(l<1){
            throw new CustomException(500,"添加失败");
        }
        return ServerResponse.createBySuccess();
    }



}
