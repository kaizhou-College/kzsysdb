package com.kz.kzsys.web.controller;

import com.github.pagehelper.PageInfo;
import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.mapper.KzScoreMapper;
import com.kz.kzsys.model.*;
import com.kz.kzsys.service.KzScoreService;
import com.kz.kzsys.service.KzStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/score")
public class KzScoreController  {
    @Autowired
    private KzStudentService ksS;

    @Autowired
    private KzScoreService kzScoreService;

    @RequestMapping("/listStudentScore")
    public String listStudent(){
        return "/front/list_student_score";
    }

    @RequestMapping("/toAddStuScore")
    public String addStuScore(){
        return "/front/add_stu_score";
    }

    @RequestMapping("/toEditStuScore")
    public ModelAndView toEditStuScore(int sid , HttpServletRequest request){
        KzScore ks= kzScoreService.selectByPrimaryKey(sid);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/front/edit_stu_score");
        mv.addObject("kzScore",ks);
        return mv;
    }
    @RequestMapping("/editStuScore")
    @ResponseBody
    public ServerResponse<String> editStuScore(KzScore ks){

        long l = kzScoreService.myUpdateByPrimaryKeySelective(ks);
        if(l>0){
            return ServerResponse.createBySuccess("更新成功");
        }else{
            return ServerResponse.createByError();
        }
    }
    @RequestMapping("/delScore")
    @ResponseBody
    public ServerResponse<String> delScore(int sid){
        long l=kzScoreService.deleteByPrimaryKey(sid);
        if (l>0){
            return ServerResponse.createBySuccess("添加成功");
        }else{
            return ServerResponse.createByError();
        }
    }


    @RequestMapping("/addScore")
    @ResponseBody
    public ServerResponse<String> addScore(KzScore ks){
        long l=kzScoreService.myInsertSelective(ks);
        if(l>0){
            return ServerResponse.createBySuccess();
        }else{
            return ServerResponse.createByError();
        }

    }

    @PostMapping("/list")
    @ResponseBody
    public ServerResponse<List> list(KzScoreQuery kcQ){
        if(kcQ.getStuName()!=null&&kcQ.getStuName().length()>0){
            List<KzStudent> stu= ksS.selectByPrimaryLiveName(kcQ);
            StringBuffer stuids=new StringBuffer();
            for(int i =0; i<stu.size();i++){
                if(stu.size()!=(i+1)){
                    stuids.append(stu.get(i).getSid()+",");
                }else {
                    stuids.append(stu.get(i).getSid());
                }

                }
            kcQ.setStuIds(stuids.toString());
        }
        System.out.print("================="+kcQ.getScore()+"=="+kcQ.getScoreType());
        PageInfo<KzScore> pageInfo = kzScoreService.getByConditionPage(kcQ);
        List<KzScore> data=pageInfo.getList();
        for(int i = 0 ;i < data.size();i++){
            KzStudent kc= ksS.selectByPrimaryKey(data.get(i).getStuid());
            if(kc!=null){
                data.get(i).setStuName(kc.getSname());
                data.get(i).setSex(kc.getSex());
            }
        }
        return  ServerResponse.createBySuccess("查询成功！！",pageInfo.getList(),pageInfo.getPageNum(),pageInfo.getPageSize(),(int)pageInfo.getTotal());
    }

}
