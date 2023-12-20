package com.example.pmchamcong.service.timekeeping.result;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class WorkerTimekeepingResult {
    private final String workerId;
    private final LocalDateTime date;
    private final int totalWorkHour;
    private final int totalOTHour;

    public WorkerTimekeepingResult(String workerId, LocalDateTime date, int totalWorkHour, int totalOTHour) {
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

    public int getTotalWorkHour() {
        return totalWorkHour;
    }

    public int getTotalOTHour() {
        return totalOTHour;
    }
}
