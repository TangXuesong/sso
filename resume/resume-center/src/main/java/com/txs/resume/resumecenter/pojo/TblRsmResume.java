package com.txs.resume.resumecenter.pojo;

public class TblRsmResume {
    private Integer rsId;

    private Integer rsUrid;

    private String rsName;

    private String rsCreateTime;

    private String rsUpdateTime;

    private String rsDelInd;

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public Integer getRsUrid() {
        return rsUrid;
    }

    public void setRsUrid(Integer rsUrid) {
        this.rsUrid = rsUrid;
    }

    public String getRsName() {
        return rsName;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName == null ? null : rsName.trim();
    }

    public String getRsCreateTime() {
        return rsCreateTime;
    }

    public void setRsCreateTime(String rsCreateTime) {
        this.rsCreateTime = rsCreateTime == null ? null : rsCreateTime.trim();
    }

    public String getRsUpdateTime() {
        return rsUpdateTime;
    }

    public void setRsUpdateTime(String rsUpdateTime) {
        this.rsUpdateTime = rsUpdateTime == null ? null : rsUpdateTime.trim();
    }

    public String getRsDelInd() {
        return rsDelInd;
    }

    public void setRsDelInd(String rsDelInd) {
        this.rsDelInd = rsDelInd == null ? null : rsDelInd.trim();
    }
}