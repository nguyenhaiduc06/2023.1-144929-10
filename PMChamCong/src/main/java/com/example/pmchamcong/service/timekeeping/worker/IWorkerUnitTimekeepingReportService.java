package com.example.pmchamcong.service.timekeeping.worker;

import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerUnitTimekeepingReport;

public interface IWorkerUnitTimekeepingReportService {
    WorkerUnitTimekeepingReport getReport(WorkerUnit unit);
    CSVData createCSVData(WorkerUnitTimekeepingReport report);
    XLSData createXLSData(WorkerUnitTimekeepingReport report);
}
