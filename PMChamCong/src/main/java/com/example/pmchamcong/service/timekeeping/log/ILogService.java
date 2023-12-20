package com.example.pmchamcong.service.timekeeping.log;

import com.example.pmchamcong.entity.Employee;
import com.example.pmchamcong.service.timekeeping.log.entity.TimekeepingLog;

import java.util.ArrayList;

public interface ILogService {
    ArrayList<TimekeepingLog> getTimekeepingLogs(Employee employee);
}
