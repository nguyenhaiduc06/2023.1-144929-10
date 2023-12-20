package com.example.pmchamcong.service.timekeeping.worker;

import com.example.pmchamcong.entity.Employee;
import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.log.ILogService;
import com.example.pmchamcong.service.timekeeping.log.entity.TimekeepingLog;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerTimekeepingResult;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerUnitTimekeepingReport;

import java.util.ArrayList;
import java.util.List;

public class WorkerUnitTimekeepingReportService implements IWorkerUnitTimekeepingReportService {
    private final IHRSystem hrSystem;
    private final ILogService logService;

    public WorkerUnitTimekeepingReportService(IHRSystem hrSystem, ILogService logService) {
        this.hrSystem = hrSystem;
        this.logService = logService;
    }

    @Override
    public WorkerUnitTimekeepingReport getReport(WorkerUnit unit) {
        ArrayList<Employee> employees = hrSystem.getEmployeesByUnit(unit);
        ArrayList<WorkerTimekeepingResult> results = new ArrayList<>();
        for (Employee employee : employees) {
            ArrayList<TimekeepingLog> logs = logService.getTimekeepingLogs(employee);
            WorkerTimekeepingResult result = new WorkerTimekeepingResult(employee, 10, 6);
            results.add(result);
        }
        return new WorkerUnitTimekeepingReport(unit, results);
    }

    @Override
    public CSVData createCSVData(WorkerUnitTimekeepingReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingResult result: report.getResults()) {
            String[] row = {result.getEmployee().getId(), result.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(result.getTotalWorkHour()), String.valueOf(result.getTotalOTHour())};
            rows.add(row);
        }
        return new CSVData(header, rows);
    }

    @Override
    public XLSData createXLSData(WorkerUnitTimekeepingReport report) {
        String[] header = {"Mã", "Tên", "Đơn vị", "Tổng số giờ làm việc", "Tổng số giờ tăng ca"};
        ArrayList<String[]> rows = new ArrayList<>();
        for (WorkerTimekeepingResult result: report.getResults()) {
            String[] row = {result.getEmployee().getId(), result.getEmployee().getName(), report.getWorkerUnit().getName(), String.valueOf(result.getTotalWorkHour()), String.valueOf(result.getTotalOTHour())};
            rows.add(row);
        }
        return new XLSData(header, rows);
    }
}
