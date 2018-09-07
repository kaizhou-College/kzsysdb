package com.kz.kzsys.web.controller;


import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.model.KzWeeklySummary;
import com.kz.kzsys.model.KzWeeklySummaryQuery;
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
@RequestMapping("/weekly")
public class KzWeeklySummaryController {

    @Autowired
    private KzWeeklySummaryService kzWeeklySummaryService;

    @RequestMapping("/weeklySummary")
    public String weeklySummary(){
        return "/front/weekly_summary";
    }

    @RequestMapping("/toAddWeeklySummary")
    public String toAddDailySummary(){
        return "/front/add_weekly_summary";
    }

    @RequestMapping("/addWeeklySummary")
    @ResponseBody
    public ServerResponse<String> addDailySummary(KzWeeklySummary kds){
        kds.setCreateTime(new Date());
        long l= kzWeeklySummaryService.insertSelective(kds);
        if (l>0){
            return ServerResponse.createBySuccess("添加成功");
        }else {
            return ServerResponse.createByError();
        }
    }

    @RequestMapping("/toEditWeeklySummary")
    public ModelAndView edit(int id, HttpServletRequest request){
        KzWeeklySummary obj =kzWeeklySummaryService.selectByPrimaryKey(id);
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("/front/edit_weekly_summary");
        view.addObject("kws", obj);
        return view;
    }
    @PostMapping("/editSubmit")
    @ResponseBody
    public ServerResponse<String> editSubmit(KzWeeklySummary kws){
        kws.setUpdateTime(new Date());
        Long result = kzWeeklySummaryService.myUpdateByPrimaryKeySelective(kws);
        return ServerResponse.createBySuccess("更新成功");
    }
    @PostMapping("/delWeeklySummary")
    @ResponseBody
    public ServerResponse<String> delWeeklySummary(int id){
        long l=kzWeeklySummaryService.deleteByPrimaryKey(id);
        if(l>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByError();
        }

    }

    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzWeeklySummaryQuery kcQ){
        PageInfo<KzWeeklySummary> pageInfo = kzWeeklySummaryService.getByConditionPage(kcQ);
        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }

}
