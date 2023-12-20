package com.example.pmchamcong.service.hrsystem.entity;

import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

public class Worker {
    private String id;
    private String name;
    private WorkerUnit workerUnit;

    public Worker(String id, String name, WorkerUnit workerUnit) {
        this.id = id;
        this.name = name;
        this.workerUnit = workerUnit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerUnit getUnit() {
        return workerUnit;
    }

    public void setUnit(WorkerUnit workerUnit) {
        this.workerUnit = workerUnit;
    }
}
