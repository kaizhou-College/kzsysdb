package com.kz.kzsys.web.controller;

import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.model.KzClass;
import com.kz.kzsys.model.KzClassQuery;
import com.kz.kzsys.model.KzDailySummary;
import com.kz.kzsys.model.KzDailySummaryQuery;
import com.kz.kzsys.service.KzClassService;
import com.kz.kzsys.service.KzDailySummaryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/daily")
public class KzDailySummaryController {
    @Autowired
    private KzDailySummaryService kzDailySummaryService;


    @RequestMapping("/dailySummary")
    public String dailySummary(){
        return "/front/daily_summary";
    }

    @RequestMapping("/toAddDailySummary")
    public String toAddDailySummary(){
        return "/front/add_daily_summary";
    }

    @PostMapping("/editDailySummary")
    @ResponseBody
    public ServerResponse<String> editSubmit(KzDailySummary ksd){
        System.out.print(ksd.getText()+"==============");
        ksd.setUpdateTime(new Date());
        Long result = kzDailySummaryService.myUpdateByPrimaryKeySelective(ksd);
        if(result>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByError();
        }
    }
    @PostMapping("/delDailySummary")
    @ResponseBody
    public ServerResponse<String> delDailySummary(KzDailySummary ksd){
        Long result = kzDailySummaryService.deleteByPrimaryKey(ksd.getDsid());
        if(result>0){
            return ServerResponse.createBySuccess("删除成功");
        }else{
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/toEditDailySummary")
    public ModelAndView editDailySummary(KzDailySummary kds){
        KzDailySummary obj=kzDailySummaryService.selectByPrimaryKey(kds.getDsid());
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/front/edit_daily_summary");
        mv.addObject("kds",obj);
        return mv;
    }

    @RequestMapping("/addDailySummary")
    @ResponseBody
    public ServerResponse<String> addDailySummary(KzDailySummary kds){
        kds.setCreateTime(new Date());
        long l= kzDailySummaryService.insertSelective(kds);
        if (l>0){
            return ServerResponse.createBySuccess("添加成功");
        }else {
            return ServerResponse.createByError();
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzDailySummaryQuery kcQ){

        PageInfo<KzDailySummary> pageInfo = kzDailySummaryService.getByConditionPage(kcQ);

        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }







}
