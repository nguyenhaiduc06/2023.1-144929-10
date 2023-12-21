package com.example.pmchamcong.service.hrsystem.entity;

import java.util.Objects;

public class Worker extends Employee {
    private WorkerUnit workerUnit;
    public Worker(String id, String name, WorkerUnit workerUnit) {
        super(id, name);
        this.workerUnit = workerUnit;
    }

    public WorkerUnit getUnit() {
        return workerUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Worker worker = (Worker) obj;

        return Objects.equals(id, worker.id)
            && Objects.equals(name, worker.name)
            && Objects.equals(workerUnit.getName(), worker.workerUnit.getName());
    }
}