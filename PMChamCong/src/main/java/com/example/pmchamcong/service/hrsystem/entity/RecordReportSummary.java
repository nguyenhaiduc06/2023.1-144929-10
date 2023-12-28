package com.example.pmchamcong.service.hrsystem.entity;

public class RecordReportSummary {

    private Integer count;
    private Integer totalWork;
    private Integer totalLate;


    public RecordReportSummary() {
    }

    public RecordReportSummary(Integer count, Integer totalWork, Integer totalLate) {
        this.count = count;
        this.totalWork = totalWork;
        this.totalLate = totalLate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalWork() {
        return totalWork;
    }

    public void setTotalWork(Integer totalWork) {
        this.totalWork = totalWork;
    }

    public Integer getTotalLate() {
        return totalLate;
    }

    public void setTotalLate(Integer totalLate) {
        this.totalLate = totalLate;
    }
}
