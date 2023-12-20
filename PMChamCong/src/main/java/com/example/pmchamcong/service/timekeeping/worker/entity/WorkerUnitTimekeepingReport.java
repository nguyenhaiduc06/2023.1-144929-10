package com.example.pmchamcong.service.timekeeping.worker.entity;

import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;

public class WorkerUnitTimekeepingReport {
    private final WorkerUnit workerUnit;
    private final ArrayList<WorkerTimekeepingResult> results;

    public WorkerUnitTimekeepingReport(WorkerUnit workerUnit, ArrayList<WorkerTimekeepingResult> results) {
        this.workerUnit = workerUnit;
        this.results = results;
    }

    public WorkerUnit getWorkerUnit() {
        return workerUnit;
    }

    public ArrayList<WorkerTimekeepingResult> getResults() {
        return results;
    }
}
