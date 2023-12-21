package com.example.pmchamcong.database;

import com.example.pmchamcong.database.entity.TimekeepingLog;
import com.example.pmchamcong.service.hrsystem.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Month;

public class DatabaseTest {
    @Test
    public void testGetTimekeepingLogsByValidEmployee() {
        Database database = new Database();

        Employee employee = new Employee("EM001", "John Doe");

        Month month = Month.JANUARY;

        var logs = database.getTimekeepingLogs(employee, month);

        Assertions.assertFalse(logs.isEmpty());

        for (TimekeepingLog log: logs) {
            Assertions.assertEquals(log.getTimestamp().getMonth(), month);
        }
    }

    @Test
    public void testGetTimekeepingLogsByInvalidEmployee() {
        Database database = new Database();

        Employee employee = new Employee("EM021", "John Doe");

        Month month = Month.JANUARY;

        var logs = database.getTimekeepingLogs(employee, month);

        Assertions.assertTrue(logs.isEmpty());
    }
}
