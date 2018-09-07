package com.kz.kzsys.model;

import com.kz.kzsys.core.web.BaseQueryModel;

public class KzScoreQuery  extends BaseQueryModel {
    private String stuIds;
    private String stuName;
    private int scoreType;
    private int score;


    public String getStuName() {
        return stuName;
    }

    public int getScoreType() {
        return scoreType;
    }

    public int getScore() {
        return score;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setScoreType(int scoreType) {
        this.scoreType = scoreType;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStuIds() {
        return stuIds;
    }

    public void setStuIds(String stuIds) {
        this.stuIds = stuIds;
    }
}
