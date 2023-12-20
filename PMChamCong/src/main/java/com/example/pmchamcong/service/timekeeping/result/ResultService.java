package com.example.pmchamcong.service.timekeeping.result;

import com.example.pmchamcong.service.hrsystem.entity.Worker;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ResultService implements IResultService {
    private final ArrayList<WorkerTimekeepingResult> results = seedResults();
    @Override
    public ArrayList<WorkerTimekeepingResult> getWorkerTimekeepingResults(Worker worker, Month month) {
        ArrayList<WorkerTimekeepingResult> filteredResults = new ArrayList<>();
        for (WorkerTimekeepingResult result: results) {
            if (Objects.equals(result.getWorkerId(), worker.getId()) && result.getDate().getMonth() == month) {
                    filteredResults.add(result);
                    System.out.println("Add");
            }
        }
        return filteredResults;
    }
    private ArrayList<WorkerTimekeepingResult> seedResults() {
        ArrayList<WorkerTimekeepingResult> results = new ArrayList<>();
        for (int i=1; i<=20; i++) {
            // 20 Workers
            ArrayList<Month> months = createMonths();
            for (Month month: months) {
                for (int dayOfMonth = 1; dayOfMonth <= 28; dayOfMonth++) {
                    LocalDateTime date = LocalDateTime.of(2023, month, dayOfMonth, 0, 0);
                    results.add(new WorkerTimekeepingResult("EM" + String.format("%03d", i), date, createWorkHour(), createOTHour()));
                }
            }
        }
        return results;
    }
    private ArrayList<Month> createMonths() {
        ArrayList<Month> months = new ArrayList<>();
        months.add(Month.JANUARY);
        months.add(Month.FEBRUARY);
        months.add(Month.MARCH);
        months.add(Month.APRIL);
        months.add(Month.MAY);
        months.add(Month.JUNE);
        months.add(Month.JULY);
        months.add(Month.AUGUST);
        months.add(Month.SEPTEMBER);
        months.add(Month.OCTOBER);
        months.add(Month.NOVEMBER);
        months.add(Month.DECEMBER);
        return months;
    }
    private int createWorkHour() {
        int workHour;
        Random random = new Random();
        double randomNumber = random.nextDouble();

        // Probability distribution: higher probability for 8
        if (randomNumber < 0.7) {
            // 70% chance for 8
            return 8;
        } else {
            // 30% chance for a number between 6 and 7
            return 6 + random.nextInt(2);
        }
    }

    private int createOTHour() {
        int workHour;
        Random random = new Random();
        double randomNumber = random.nextDouble();

        // Probability distribution: higher probability for 0
        if (randomNumber < 0.6) {
            // 60% chance for 0
            return 0;
        } else {
            // 40% chance for a number between 1 and 4
            return 1 + random.nextInt(4);
        }
    }
}
