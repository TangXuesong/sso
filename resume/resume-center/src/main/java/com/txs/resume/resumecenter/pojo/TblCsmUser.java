package com.txs.resume.resumecenter.pojo;

public class TblCsmUser {
    private Integer urId;

    private String urNickname;

    private String urEmail;

    private String urPassword;

    private String urSex;

    private Integer urAge;

    private String urRegisterTime;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrNickname() {
        return urNickname;
    }

    public void setUrNickname(String urNickname) {
        this.urNickname = urNickname == null ? null : urNickname.trim();
    }

    public String getUrEmail() {
        return urEmail;
    }

    public void setUrEmail(String urEmail) {
        this.urEmail = urEmail == null ? null : urEmail.trim();
    }

    public String getUrPassword() {
        return urPassword;
    }

    public void setUrPassword(String urPassword) {
        this.urPassword = urPassword == null ? null : urPassword.trim();
    }

    public String getUrSex() {
        return urSex;
    }

    public void setUrSex(String urSex) {
        this.urSex = urSex == null ? null : urSex.trim();
    }

    public Integer getUrAge() {
        return urAge;
    }

    public void setUrAge(Integer urAge) {
        this.urAge = urAge;
    }

    public String getUrRegisterTime() {
        return urRegisterTime;
    }

    public void setUrRegisterTime(String urRegisterTime) {
        this.urRegisterTime = urRegisterTime == null ? null : urRegisterTime.trim();
    }
}