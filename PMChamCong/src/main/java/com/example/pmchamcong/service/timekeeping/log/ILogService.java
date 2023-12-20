package com.example.pmchamcong.service.timekeeping.log;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.timekeeping.log.entity.TimekeepingLog;

import java.util.ArrayList;

public interface ILogService {
    ArrayList<TimekeepingLog> getTimekeepingLogs(Worker worker);
}
