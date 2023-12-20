package com.example.pmchamcong.service.timekeeping.worker.entity;

import com.example.pmchamcong.entity.Employee;

public class WorkerTimekeepingResult {
    private final Employee employee;
    private final int totalWorkHour;
    private final int totalOTHour;

    public WorkerTimekeepingResult(Employee employee, int totalWorkHour, int totalOTHour) {
        this.employee = employee;
        this.totalWorkHour = totalWorkHour;
        this.totalOTHour = totalOTHour;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getTotalWorkHour() {
        return totalWorkHour;
    }

    public int getTotalOTHour() {
        return totalOTHour;
    }
}
