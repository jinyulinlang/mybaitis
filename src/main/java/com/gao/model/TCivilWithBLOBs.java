package com.gao.model;

public class TCivilWithBLOBs extends TCivil {
    private byte[] pic;

    private String remark;

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}