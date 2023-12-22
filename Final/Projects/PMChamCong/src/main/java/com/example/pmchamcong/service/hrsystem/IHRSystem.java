package com.example.pmchamcong.service.hrsystem;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;

public interface IHRSystem {
    ArrayList<WorkerUnit> getAllWorkerUnits();
    ArrayList<Worker> getEmployeesByUnit(WorkerUnit workerUnit);
}
