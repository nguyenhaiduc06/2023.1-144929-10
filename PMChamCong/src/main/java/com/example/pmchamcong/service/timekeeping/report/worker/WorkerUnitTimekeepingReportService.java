package com.example.pmchamcong.service.timekeeping.report.worker;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.log.ILogService;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerTimekeepingSummary;
import com.example.pmchamcong.service.timekeeping.result.IResultService;
import com.example.pmchamcong.service.timekeeping.result.WorkerTimekeepingResult;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitTimekeepingReport;

import java.time.Month;
import java.util.ArrayList;

public class WorkerUnitTimekeepingReportService implements IWorkerUnitTimekeepingReportService {
    private final IHRSystem hrSystem;
    private final ILogService logService;
    private final IResultService resultService;

    public WorkerUnitTimekeepingReportService(IHRSystem hrSystem, ILogService logService, IResultService resultService) {
        this.hrSystem = hrSystem;
        this.logService = logService;
        this.resultService = resultService;
    }

    @Override
    public WorkerUnitTimekeepingReport getReport(WorkerUnit unit, Month month) {
        ArrayList<Worker> workers = hrSystem.getEmployeesByUnit(unit);
        ArrayList<WorkerTimekeepingSummary> summaries = new ArrayList<>();
        System.out.println("Selected month ");
        System.out.println(month);
        for (Worker worker : workers) {
            ArrayList<WorkerTimekeepingResult> results = resultService.getWorkerTimekeepingResults(worker, month);
            if (results.isEmpty()) {
                continue;
            }
            int totalWorkHour = 0;
            int totalOTHour = 0;
            for (WorkerTimekeepingResult result: results) {
                totalWorkHour += result.getTotalWorkHour();
                totalOTHour += result.getTotalOTHour();
            }
            WorkerTimekeepingSummary summary = new WorkerTimekeepingSummary(worker, totalWorkHour, totalOTHour);
            summaries.add(summary);
        }
        return new WorkerUnitTimekeepingReport(unit, summaries);
    }

    @Override
    public CSVData createCSVData(WorkerUnitTimekeepingReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingSummary summary: report.getSummaries()) {
            String[] row = {summary.getEmployee().getId(), summary.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(summary.getTotalWorkHour()), String.valueOf(summary.getTotalOTHour())};
            rows.add(row);
        }
        return new CSVData(header, rows);
    }

    @Override
    public XLSData createXLSData(WorkerUnitTimekeepingReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingSummary summary: report.getSummaries()) {
            String[] row = {summary.getEmployee().getId(), summary.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(summary.getTotalWorkHour()), String.valueOf(summary.getTotalOTHour())};
            rows.add(row);
        }
        return new XLSData(header, rows);
    }
}
