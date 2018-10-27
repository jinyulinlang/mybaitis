package com.gao.model;

public class TStudent {
    private Integer id;

    private String name;

    private Integer age;
    private TAddress tAddress;
    private TGrade tGrade;

    public TStudent() {
    }

    public TStudent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public TStudent(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public TGrade gettGrade() {
        return tGrade;
    }

    public void settGrade(TGrade tGrade) {
        this.tGrade = tGrade;
    }

    public TAddress gettAddress() {
        return tAddress;
    }

    public void settAddress(TAddress tAddress) {
        this.tAddress = tAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}