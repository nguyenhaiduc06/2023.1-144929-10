package com.example.pmchamcong.service.timekeeping.result;

import com.example.pmchamcong.database.Database;
import com.example.pmchamcong.database.IDatabase;
import com.example.pmchamcong.database.entity.TimekeepingLog;
import com.example.pmchamcong.helper.Helper;
import com.example.pmchamcong.service.hrsystem.entity.Worker;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class ResultService implements IResultService {
    private IDatabase database = new Database();
    private final ArrayList<WorkerTimekeepingResult> results = seedResults();
    @Override
    public ArrayList<WorkerTimekeepingResult> getWorkerTimekeepingResults(Worker worker, Month month) {
        ArrayList<TimekeepingLog> logs = database.getTimekeepingLogs(worker, month);
        // Map Day of month to a HashMap. This HashMap map shift to and Array of check in and checkout time
        HashMap<Integer, HashMap<Integer, LocalDateTime>> logTimes = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Duration>> listDurationByDay = new HashMap<>();
        for (TimekeepingLog log: logs) {
            LocalDateTime currentTimestamp = log.getTimestamp();
            int day = currentTimestamp.getDayOfMonth();

            if (!logTimes.containsKey(day)) {
                logTimes.put(day, new HashMap<>());
            }
            if (!listDurationByDay.containsKey(day)) {
                listDurationByDay.put(day, new HashMap<>());
            }

            HashMap<Integer, LocalDateTime> timestampsByShift = logTimes.get(day);
            int shift = Helper.getWorkerShiftByTimestamp(log.getTimestamp());
            if (!timestampsByShift.containsKey(shift)) {
                timestampsByShift.put(shift, currentTimestamp);
            } else {
                LocalDateTime otherTimestamp = timestampsByShift.get(shift);
                Duration duration = Duration.between(currentTimestamp, otherTimestamp);

                listDurationByDay.get(day).put(shift, duration);
            }
        }
        ArrayList<WorkerTimekeepingResult> results = new ArrayList<>();
        for (HashMap.Entry<Integer, HashMap<Integer, Duration>> entry : listDurationByDay.entrySet()) {
            Integer day = entry.getKey();
            HashMap<Integer, Duration> durationByShift = entry.getValue();
            long workHour = Math.abs(durationByShift.get(1).toHours() + durationByShift.get(2).toHours());
            long otHour = Math.abs(durationByShift.get(2).toHours());
            results.add(new WorkerTimekeepingResult(worker.getId(), LocalDateTime.of(2023, month, day, 0, 0), workHour, otHour));
        }

        return results;
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
