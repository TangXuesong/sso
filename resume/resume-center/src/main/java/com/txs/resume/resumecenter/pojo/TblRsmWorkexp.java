package com.txs.resume.resumecenter.pojo;

public class TblRsmWorkexp {
    private Integer wpId;

    private Integer wpRlid;

    private String wpCompname;

    private String wpStarttime;

    private String wpEndtime;

    private String wpOccupation;

    private String wpWorkcontext;

    private String wpCreateTime;

    private String wpUpdateTime;

    public Integer getWpId() {
        return wpId;
    }

    public void setWpId(Integer wpId) {
        this.wpId = wpId;
    }

    public Integer getWpRlid() {
        return wpRlid;
    }

    public void setWpRlid(Integer wpRlid) {
        this.wpRlid = wpRlid;
    }

    public String getWpCompname() {
        return wpCompname;
    }

    public void setWpCompname(String wpCompname) {
        this.wpCompname = wpCompname == null ? null : wpCompname.trim();
    }

    public String getWpStarttime() {
        return wpStarttime;
    }

    public void setWpStarttime(String wpStarttime) {
        this.wpStarttime = wpStarttime == null ? null : wpStarttime.trim();
    }

    public String getWpEndtime() {
        return wpEndtime;
    }

    public void setWpEndtime(String wpEndtime) {
        this.wpEndtime = wpEndtime == null ? null : wpEndtime.trim();
    }

    public String getWpOccupation() {
        return wpOccupation;
    }

    public void setWpOccupation(String wpOccupation) {
        this.wpOccupation = wpOccupation == null ? null : wpOccupation.trim();
    }

    public String getWpWorkcontext() {
        return wpWorkcontext;
    }

    public void setWpWorkcontext(String wpWorkcontext) {
        this.wpWorkcontext = wpWorkcontext == null ? null : wpWorkcontext.trim();
    }

    public String getWpCreateTime() {
        return wpCreateTime;
    }

    public void setWpCreateTime(String wpCreateTime) {
        this.wpCreateTime = wpCreateTime == null ? null : wpCreateTime.trim();
    }

    public String getWpUpdateTime() {
        return wpUpdateTime;
    }

    public void setWpUpdateTime(String wpUpdateTime) {
        this.wpUpdateTime = wpUpdateTime == null ? null : wpUpdateTime.trim();
    }
}