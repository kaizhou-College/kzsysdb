package com.kz.kzsys.web.controller;


import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.model.KzTremSummary;
import com.kz.kzsys.model.KzTremSummaryQuery;
import com.kz.kzsys.model.KzWeeklySummary;
import com.kz.kzsys.service.KzTremSummaryService;
import com.kz.kzsys.service.KzWeeklySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/term")
public class KzTremSummaryController {

    @Autowired
    private KzTremSummaryService kzTremSummaryService;

    @RequestMapping("/termSummary")
    public String termSummary(){
        return "/front/term_summary";
    }
    @RequestMapping("/toAddTermSummary")
    public String toAddTermSummary(){
        return "/front/add_term_summary";
    }
    @RequestMapping("/addTermSummary")
    @ResponseBody
    public ServerResponse<String> addTermSummary(KzTremSummary kts){
        kts.setCreateTime(new Date());
        long l= kzTremSummaryService.insertSelective(kts);
        if (l>0){
            return ServerResponse.createBySuccess("添加成功");
        }else {
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/toEditTermSummary")
    public ModelAndView toEditTermSummary(int id, HttpServletRequest request){
        KzTremSummary obj =kzTremSummaryService.selectByPrimaryKey(id);
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("/front/edit_term_summary");
        view.addObject("kts", obj);
        return view;
    }

    @PostMapping("editTermSummary")
    @ResponseBody
    public ServerResponse<String> editTermSummary(KzTremSummary kts){
        long l=kzTremSummaryService.myUpdateByPrimaryKeySelective(kts);
        if(l>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByError();

        }
    }

    @PostMapping("/delTermSummary")
    @ResponseBody
    public ServerResponse<String> delTermSummary(int id){
        long l=kzTremSummaryService.deleteByPrimaryKey(id);
        if(l>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByError();
        }

    }

    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzTremSummaryQuery ktQ){
        PageInfo<KzTremSummary> pageInfo = kzTremSummaryService.getByConditionPage(ktQ);

        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }


}
