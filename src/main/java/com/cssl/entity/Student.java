package com.cssl.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

    private Integer sid;
    private String sname;
    private Date bonrdate;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBonrdate() {
        return bonrdate;
    }

    public void setBonrdate(Date bonrdate) {
        this.bonrdate = bonrdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", bonrdate=" + bonrdate +
                '}';
    }

    public Student(Integer sid, String sname, Date bonrdate) {
        this.sid = sid;
        this.sname = sname;
        this.bonrdate = bonrdate;
    }

    public Student() {
    }
}
