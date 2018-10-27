package com.gao.model;

public class TAddress {
    private Integer id;

    private String province;

    private String city;

    private String area;

    public TAddress() {
    }

    public TAddress(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }


}