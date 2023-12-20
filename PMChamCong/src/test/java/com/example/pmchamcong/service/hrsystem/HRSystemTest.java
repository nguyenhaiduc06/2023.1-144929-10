package com.example.pmchamcong.service.hrsystem;

import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HRSystemTest {

    private HRSystem hrSystem;

    @BeforeEach
    public void setUp() {
        hrSystem = new HRSystem();
    }

    @Test
    public void testGetEmployeesByValidUnit() {
        // Test case: workerUnit = cn1 (đơn vị hợp lệ trả về ds nhân viên)
        WorkerUnit validUnit = new WorkerUnit("CN1");
        ArrayList<Worker> result = hrSystem.getEmployeesByUnit(validUnit);
        assertEquals(6, result.size());
    }

    @Test
    public void testGetEmployeesByInvalidUnit() {
        // Test case: workerUnit = vp1 (đơn vị không hợp lệ, thông báo lỗi)
        WorkerUnit invalidUnit = new WorkerUnit("VP1");
        ArrayList<Worker> result = hrSystem.getEmployeesByUnit(invalidUnit);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetEmployeesByValidEmptyUnit() {
        // Test case: workerUnit = cn4 (đơn vị hợp lệ nhưng không có nhân viên)
        WorkerUnit emptyUnit = new WorkerUnit("CN4");
        ArrayList<Worker> result = hrSystem.getEmployeesByUnit(emptyUnit);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetEmployeesByNullUnit() {
        // Test case: workerUnit = null (đơn vị rỗng)
        ArrayList<Worker> result = hrSystem.getEmployeesByUnit(null);
        assertTrue(result.isEmpty());
    }
}
