package com.example.pmchamcong.service.hrsystem;

import com.example.pmchamcong.entity.Employee;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;

public interface IHRSystem {
    ArrayList<WorkerUnit> getAllWorkerUnits();

    Employee getEmployeeById(String id);

    ArrayList<Employee> getEmployeesByUnit(WorkerUnit workerUnit);
}
