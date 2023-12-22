package com.example.pmchamcong.service.timekeeping.result;

import com.example.pmchamcong.service.hrsystem.entity.Worker;

import java.time.Month;
import java.util.ArrayList;

public interface IResultService {
    public ArrayList<WorkerTimekeepingResult> getWorkerTimekeepingResults(Worker worker, Month month);
}
