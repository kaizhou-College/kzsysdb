package com.kz.kzsys.model;

import com.kz.kzsys.core.model.BaseModel;

import java.util.Date;

public class KzScore  extends BaseModel {
    private Integer scoreid;

    private String type;

    private Integer midOne;

    private Integer endOne;

    private Integer midTwo;

    private Integer endTwo;

    private Integer midThree;

    private Integer endThree;

    private Integer stuid;

    private Integer kzDailySummary;

    private Integer dsid;

    private String title;

    private Date createTime;

    private Date updateTime;

    private Integer userid;

    //下面这个是我用来添加使用的学生字段
    private String stuName;
    private String sex;

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getMidOne() {
        return midOne;
    }

    public void setMidOne(Integer midOne) {
        this.midOne = midOne;
    }

    public Integer getEndOne() {
        return endOne;
    }

    public void setEndOne(Integer endOne) {
        this.endOne = endOne;
    }

    public Integer getMidTwo() {
        return midTwo;
    }

    public void setMidTwo(Integer midTwo) {
        this.midTwo = midTwo;
    }

    public Integer getEndTwo() {
        return endTwo;
    }

    public void setEndTwo(Integer endTwo) {
        this.endTwo = endTwo;
    }

    public Integer getMidThree() {
        return midThree;
    }

    public void setMidThree(Integer midThree) {
        this.midThree = midThree;
    }

    public Integer getEndThree() {
        return endThree;
    }

    public void setEndThree(Integer endThree) {
        this.endThree = endThree;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getKzDailySummary() {
        return kzDailySummary;
    }

    public void setKzDailySummary(Integer kzDailySummary) {
        this.kzDailySummary = kzDailySummary;
    }

    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}