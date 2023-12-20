package com.example.pmchamcong.service.timekeeping.report.worker;

import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitTimekeepingReport;

import java.time.Month;

public interface IWorkerUnitTimekeepingReportService {
    WorkerUnitTimekeepingReport getReport(WorkerUnit unit, Month month);
    CSVData createCSVData(WorkerUnitTimekeepingReport report);
    XLSData createXLSData(WorkerUnitTimekeepingReport report);
}
