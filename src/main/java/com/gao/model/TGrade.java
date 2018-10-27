package com.gao.model;

import java.util.List;

public class TGrade {
    private Integer id;

    private String gradeName;
    private List<TStudent> tStudents;

    public TGrade() {
    }

    public TGrade(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<TStudent> gettStudents() {
        return tStudents;
    }

    public void settStudents(List<TStudent> tStudents) {
        this.tStudents = tStudents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }
}