package com.example.pmchamcong.service.timekeeping.result;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class WorkerTimekeepingResult {
    private final String workerId;
    private final LocalDateTime date;
    private final long totalWorkHour;
    private final long totalOTHour;

    public WorkerTimekeepingResult(String workerId, LocalDateTime date, long totalWorkHour, long totalOTHour) {
        this.workerId = workerId;
        this.date = date;
        this.totalWorkHour = totalWorkHour;
        this.totalOTHour = totalOTHour;
    }

    public String getWorkerId() {
        return workerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public long getTotalWorkHour() {
        return totalWorkHour;
    }

    public long getTotalOTHour() {
        return totalOTHour;
    }
}
