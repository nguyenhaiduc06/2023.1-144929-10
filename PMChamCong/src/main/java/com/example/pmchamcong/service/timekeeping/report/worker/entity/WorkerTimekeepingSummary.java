package com.example.pmchamcong.service.timekeeping.report.worker.entity;

import com.example.pmchamcong.service.hrsystem.entity.Worker;


public class WorkerTimekeepingSummary {
    private final Worker worker;
    private final int totalWorkHour;
    private final int totalOTHour;

    public WorkerTimekeepingSummary(Worker worker, int totalWorkHour, int totalOTHour) {
        this.worker = worker;
        this.totalWorkHour = totalWorkHour;
        this.totalOTHour = totalOTHour;
    }

    public Worker getEmployee() {
        return worker;
    }


    public int getTotalWorkHour() {
        return totalWorkHour;
    }

    public int getTotalOTHour() {
        return totalOTHour;
    }
}
