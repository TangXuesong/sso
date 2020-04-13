package com.txs.resume.resumecenter.pojo;

public class TblRsmProjexp {
    private Integer ppId;

    private Integer ppWpid;

    private String ppName;

    private String ppStarttime;

    private String ppEndtime;

    private String ppProjdesc;

    private String ppWorkdesc;

    private String ppCreateTime;

    private String ppUpdateTime;

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getPpWpid() {
        return ppWpid;
    }

    public void setPpWpid(Integer ppWpid) {
        this.ppWpid = ppWpid;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName == null ? null : ppName.trim();
    }

    public String getPpStarttime() {
        return ppStarttime;
    }

    public void setPpStarttime(String ppStarttime) {
        this.ppStarttime = ppStarttime == null ? null : ppStarttime.trim();
    }

    public String getPpEndtime() {
        return ppEndtime;
    }

    public void setPpEndtime(String ppEndtime) {
        this.ppEndtime = ppEndtime == null ? null : ppEndtime.trim();
    }

    public String getPpProjdesc() {
        return ppProjdesc;
    }

    public void setPpProjdesc(String ppProjdesc) {
        this.ppProjdesc = ppProjdesc == null ? null : ppProjdesc.trim();
    }

    public String getPpWorkdesc() {
        return ppWorkdesc;
    }

    public void setPpWorkdesc(String ppWorkdesc) {
        this.ppWorkdesc = ppWorkdesc == null ? null : ppWorkdesc.trim();
    }

    public String getPpCreateTime() {
        return ppCreateTime;
    }

    public void setPpCreateTime(String ppCreateTime) {
        this.ppCreateTime = ppCreateTime == null ? null : ppCreateTime.trim();
    }

    public String getPpUpdateTime() {
        return ppUpdateTime;
    }

    public void setPpUpdateTime(String ppUpdateTime) {
        this.ppUpdateTime = ppUpdateTime == null ? null : ppUpdateTime.trim();
    }
}