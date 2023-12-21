package com.example.pmchamcong.helper;

import java.time.LocalDateTime;
import java.util.Random;

public class Helper {
    public static LocalDateTime createRandomCheckInTime(int year, int month, int day, int shift) {
        // Check if the inputs are within valid ranges
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid day or month");
        }

        Random random = new Random();
        int checkInHour;
        switch (shift) {
            case 1:
                checkInHour = 8;
                break;
            case 2:
                checkInHour = 14;
                break;
            case 3:
                checkInHour = 20;
                break;
            default:
                checkInHour = 8;
                break;
        }

        int checkInMinute = random.nextInt(30); // Minutes between 0 and 29
        return LocalDateTime.of(year, month, day, checkInHour, checkInMinute);
    }
    public static LocalDateTime createRandomCheckOutTime(int year, int month, int day, int shift) {
        // Check if the inputs are within valid ranges
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid day or month");
        }

        Random random = new Random();
        int checkOutHour;
        switch (shift) {
            case 1:
                checkOutHour = 12;
                break;
            case 2:
                checkOutHour = 16;
                break;
            case 3:
                checkOutHour = 22;
                break;
            default:
                checkOutHour = 12;
                break;
        }

        int checkOutMinute = random.nextInt(30); // Minutes between 0 and 29
        return LocalDateTime.of(year, month, day, checkOutHour, checkOutMinute);
    }
    public static int getWorkerShiftByTimestamp(LocalDateTime timestamp) {
        int hour = timestamp.getHour();
        if (0 < hour && hour < 13) {
            return 1;
        }
        if (13 <= hour && hour < 19) {
            return 2;
        }
        return 3;
    }
}
