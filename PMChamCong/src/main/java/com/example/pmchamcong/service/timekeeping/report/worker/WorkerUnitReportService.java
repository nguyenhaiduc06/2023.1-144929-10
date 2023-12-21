package com.example.pmchamcong.service.timekeeping.report.worker;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerTimekeepingSummary;
import com.example.pmchamcong.service.timekeeping.result.IResultService;
import com.example.pmchamcong.service.timekeeping.result.ResultService;
import com.example.pmchamcong.service.timekeeping.result.WorkerTimekeepingResult;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitReport;

import java.time.Month;
import java.util.ArrayList;

public class WorkerUnitReportService implements IWorkerUnitReportService {
    private final IHRSystem hrSystem;
    private final IResultService resultService = new ResultService();

    public WorkerUnitReportService(IHRSystem hrSystem) {
        this.hrSystem = hrSystem;
    }

    @Override
    public WorkerUnitReport getReport(WorkerUnit unit, Month month) {
        ArrayList<Worker> workers = hrSystem.getEmployeesByUnit(unit);
        ArrayList<WorkerTimekeepingSummary> summaries = new ArrayList<>();
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
        return new WorkerUnitReport(unit, summaries);
    }

    @Override
    public CSVData createCSVData(WorkerUnitReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingSummary summary: report.getSummaries()) {
            String[] row = {summary.getEmployee().getId(), summary.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(summary.getTotalWorkHour()), String.valueOf(summary.getTotalOTHour())};
            rows.add(row);
        }
        return new CSVData(header, rows);
    }

    @Override
    public XLSData createXLSData(WorkerUnitReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingSummary summary: report.getSummaries()) {
            String[] row = {summary.getEmployee().getId(), summary.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(summary.getTotalWorkHour()), String.valueOf(summary.getTotalOTHour())};
            rows.add(row);
        }
        return new XLSData(header, rows);
    }
}
