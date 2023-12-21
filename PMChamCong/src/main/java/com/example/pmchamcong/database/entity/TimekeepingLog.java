package com.example.pmchamcong.database.entity;

import java.time.LocalDateTime;

public class TimekeepingLog {
    private String employeeId;
    private LocalDateTime timestamp;
    private TimekeepingLogType type;
    public TimekeepingLog(String employeeId, LocalDateTime timestamp, TimekeepingLogType type) {
        this.employeeId = employeeId;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public TimekeepingLogType getType() {
        return type;
    }
}
