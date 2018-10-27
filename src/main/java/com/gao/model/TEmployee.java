package com.gao.model;

public class TEmployee {
    private Integer id;

    private String name;

    private Integer employeeNo;

    private Integer deptNo;

    public TEmployee() {
    }

    public TEmployee(String name, Integer employeeNo, Integer deptNo) {
        this.name = name;
        this.employeeNo = employeeNo;
        this.deptNo = deptNo;
    }

    public TEmployee(Integer id, String name, Integer employeeNo, Integer deptNo) {
        this.id = id;
        this.name = name;
        this.employeeNo = employeeNo;
        this.deptNo = deptNo;
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

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}