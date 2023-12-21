package com.example.pmchamcong.database;

import com.example.pmchamcong.database.entity.TimekeepingLog;
import com.example.pmchamcong.database.entity.TimekeepingLogType;
import com.example.pmchamcong.helper.Helper;
import com.example.pmchamcong.service.hrsystem.entity.Employee;
import com.example.pmchamcong.service.timekeeping.result.WorkerTimekeepingResult;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class Database implements IDatabase{
    private ArrayList<TimekeepingLog> timekeepingLogs = new ArrayList<>();
    public Database() {
        seed();;
    }

    @Override
    public ArrayList<TimekeepingLog> getTimekeepingLogs(Employee employee, Month month) {
        ArrayList<TimekeepingLog> logs = new ArrayList<>();
        for (TimekeepingLog log: timekeepingLogs) {
            if (Objects.equals(log.getEmployeeId(), employee.getId()) && log.getTimestamp().getMonth() == month) {
                logs.add(log);
            }
        }
        return logs;
    }

    private void seed() {
        seedTimekeepingLogs();
    }

    private void seedTimekeepingLogs() {
        for (int i = 1; i <= 20; i++) {
            for (int month = 1; month <= 12; month++) {
                for (int dayOfMonth = 1; dayOfMonth <= 28; dayOfMonth++) {
                    for (int shift = 1; shift <= 3; shift ++) {
                        String employeeId = "EM" + String.format("%03d", i);
                        LocalDateTime checkInTime = Helper.createRandomCheckInTime(2023, month, dayOfMonth, shift);
                        LocalDateTime checkOutTime = Helper.createRandomCheckOutTime(2023, month, dayOfMonth, shift);
                        timekeepingLogs.add(new TimekeepingLog(employeeId, checkInTime, TimekeepingLogType.CHECK_IN));
                        timekeepingLogs.add(new TimekeepingLog(employeeId, checkOutTime, TimekeepingLogType.CHECK_OUT));

                    }
                }
            }
        }
    }
}
