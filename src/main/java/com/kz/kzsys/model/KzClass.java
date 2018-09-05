package com.kz.kzsys.model;


import com.kz.kzsys.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

public class KzClass extends BaseModel{
    private int id;
    private String className;
    private String grade;
    private String schoolName;
    private int stuNum;
    private String firstResponsiblePerson;
    private String secondResponsiblePerson;
    private int status;
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getFirstResponsiblePerson() {

        return firstResponsiblePerson;
    }

    public void setFirstResponsiblePerson(String firstResponsiblePerson) {
        this.firstResponsiblePerson = firstResponsiblePerson;
    }

    public String getSecondResponsiblePerson() {
        if(secondResponsiblePerson==null)
            return "无";
        return secondResponsiblePerson;
    }

    public void setSecondResponsiblePerson(String secondResponsiblePerson) {
        this.secondResponsiblePerson = secondResponsiblePerson;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "KzClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", grade='" + grade + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", stuNum=" + stuNum +
                ", firstResponsiblePerson='" + firstResponsiblePerson + '\'' +
                ", secondeResponsiblePerson='" + secondResponsiblePerson + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
