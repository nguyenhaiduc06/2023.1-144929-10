package com.example.pmchamcong.service.hrsystem.entity;

public class Worker extends Employee {
    private WorkerUnit workerUnit;
    public Worker(String id, String name, WorkerUnit workerUnit) {
        super(id, name);
        this.workerUnit = workerUnit;
    }

    public WorkerUnit getUnit() {
        return workerUnit;
    }
}