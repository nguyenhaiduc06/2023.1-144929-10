package com.example.pmchamcong.service.timekeeping.report.worker.entity;

import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;

public class WorkerUnitTimekeepingReport {
    private final WorkerUnit workerUnit;
    private final ArrayList<WorkerTimekeepingSummary> summaries;

    public WorkerUnitTimekeepingReport(WorkerUnit workerUnit, ArrayList<WorkerTimekeepingSummary> summaries) {
        this.workerUnit = workerUnit;
        this.summaries = summaries;
    }

    public WorkerUnit getWorkerUnit() {
        return workerUnit;
    }

    public ArrayList<WorkerTimekeepingSummary> getSummaries() {
        return summaries;
    }
}
