package com.kz.kzsys.model;


import com.kz.kzsys.core.web.BaseQueryModel;

public class KzClassQuery extends BaseQueryModel {
    private String className;
    private int status;

    public String getClassName() {
        return className;
    }

    public int getStatus() {
        return status;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
