package com.example.pmchamcong.entity;

public class EmployeeTimekeepingResult {
    private final Employee employee;
    private final int totalSession;
    private final int totalLateHour;
    private final int totalLeaveSoonHour;

    public EmployeeTimekeepingResult(Employee employee, int totalSession, int totalLateHour, int totalLeaveSoonHour) {
        this.employee = employee;
        this.totalSession = totalSession;
        this.totalLateHour = totalLateHour;
        this.totalLeaveSoonHour = totalLeaveSoonHour;
    }

    public Employee getEmployee() {
        return employee;
    }
}
