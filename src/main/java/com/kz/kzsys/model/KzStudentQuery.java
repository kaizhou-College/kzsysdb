package com.kz.kzsys.model;

import com.kz.kzsys.core.web.BaseQueryModel;

public class KzStudentQuery   extends BaseQueryModel {
    private String sname;
    private int status;

    public String getSname() {
        return sname;
    }

    public int getStatus() {
        return status;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
