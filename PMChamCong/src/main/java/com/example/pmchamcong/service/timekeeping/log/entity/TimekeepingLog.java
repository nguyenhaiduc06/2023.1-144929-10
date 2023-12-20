package com.example.pmchamcong.service.timekeeping.log.entity;

import java.sql.Timestamp;

public class TimekeepingLog {
    private final String employeeId;
    private final TimekeepingLogType type;
    private final Timestamp timestamp;

    public TimekeepingLog(String employeeId, TimekeepingLogType type, Timestamp timestamp) {
        this.employeeId = employeeId;
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public TimekeepingLogType getType() {
        return type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
