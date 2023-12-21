package com.example.pmchamcong.service.hrsystem.entity;

<<<<<<< HEAD
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.Objects;

public class Worker {
    private String id;
    private String name;
=======
public class Worker extends Employee {
>>>>>>> cc7fdb9dca5bba0672e7c08921ba2f14016a10e0
    private WorkerUnit workerUnit;

    public Worker(String id, String name, WorkerUnit workerUnit) {
        super(id, name);
        this.workerUnit = workerUnit;
    }
    public WorkerUnit getUnit() {
        return workerUnit;
    }
}
