package com.example.pmchamcong.service.hrsystem.entity;

public class RecordReport {
    private int id;
    private String fullname;
    private String  code;

    private String department;

    private int month;
    private int workHour;

    private int lateHour;

    public RecordReport() {
    }

    public RecordReport(int id,  String code,String fullname, String department, int month, int workHour, int lateHour) {
        this.id = id;
        this.fullname = fullname;
        this.code = code;
        this.department = department;
        this.month = month;
        this.workHour = workHour;
        this.lateHour = lateHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getLateHour() {
        return lateHour;
    }

    public void setLateHour(int lateHour) {
        this.lateHour = lateHour;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
