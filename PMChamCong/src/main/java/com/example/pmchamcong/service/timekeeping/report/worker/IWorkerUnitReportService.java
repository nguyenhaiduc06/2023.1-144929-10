package com.example.pmchamcong.service.timekeeping.report.worker;

import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitReport;

import java.time.Month;

public interface IWorkerUnitReportService {
    WorkerUnitReport getReport(WorkerUnit unit, Month month);
    CSVData createCSVData(WorkerUnitReport report);
    XLSData createXLSData(WorkerUnitReport report);
}
