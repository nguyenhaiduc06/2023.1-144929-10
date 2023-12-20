package com.example.pmchamcong.service.timekeeping.log;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.timekeeping.log.entity.TimekeepingLog;
import com.example.pmchamcong.service.timekeeping.log.entity.TimekeepingLogType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class LogService implements ILogService {
    private final ArrayList<TimekeepingLog> logs = seedLogs();

    @Override
    public ArrayList<TimekeepingLog> getTimekeepingLogs(Worker worker) {
        ArrayList<TimekeepingLog> results = new ArrayList<>();
        for (TimekeepingLog log : logs) {
            if (Objects.equals(log.getEmployeeId(), worker.getId())) {
                results.add(log);
            }
        }
        return results;
    }

    private ArrayList<TimekeepingLog> seedLogs() {
        ArrayList<TimekeepingLog> logs = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String employeeId = String.format("EM%03d", i); // Format the number with leading zeros
            TimekeepingLogType type = TimekeepingLogType.CHECK_IN; // You can modify this value as needed
            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // You can modify this value as needed
            logs.add(new TimekeepingLog(employeeId, type, timestamp));
        }
        return logs;
    }
}
