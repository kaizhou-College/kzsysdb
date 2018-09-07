package com.kz.kzsys.model;

import com.kz.kzsys.core.model.BaseModel;

import java.util.Date;

public class KzWeeklySummary   extends BaseModel {
    private Integer wsid;

    private String title;

    private Date createTime;

    private Date updateTime;

    private Integer userid;

    private String tetx;

    public Integer getWsid() {
        return wsid;
    }

    public void setWsid(Integer wsid) {
        this.wsid = wsid;
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

    public String getTetx() {
        return tetx;
    }

    public void setTetx(String tetx) {
        this.tetx = tetx == null ? null : tetx.trim();
    }
}