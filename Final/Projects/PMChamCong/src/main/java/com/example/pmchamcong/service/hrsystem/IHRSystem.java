package com.example.pmchamcong.service.hrsystem;

import com.example.pmchamcong.service.hrsystem.entity.RecordReport;
import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface IHRSystem {
    ArrayList<WorkerUnit> getAllWorkerUnits();
    ArrayList<Worker> getEmployeesByUnit(WorkerUnit workerUnit);

    List<RecordReport> getAllByDepartmentName(String departmentName, Integer month);

    Set<String> getAllDepartmentName();
}
