package com.example.pmchamcong.database;

import com.example.pmchamcong.database.entity.TimekeepingLog;
import com.example.pmchamcong.service.hrsystem.entity.Worker;

import java.time.Month;
import java.util.ArrayList;

public interface IDatabase {
    public ArrayList<TimekeepingLog> getTimekeepingLogs(Worker employee, Month month);
}
