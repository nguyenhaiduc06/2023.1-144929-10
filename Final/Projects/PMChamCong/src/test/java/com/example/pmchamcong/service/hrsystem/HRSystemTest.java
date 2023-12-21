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
        // Test case: workerUnit = CN1 (đơn vị hợp lệ trả về danh sách nhân viên)
        WorkerUnit validUnit = new WorkerUnit("CN1");
        ArrayList<Worker> result = hrSystem.getEmployeesByUnit(validUnit);
    
        // Danh sách nhân viên kiểm tra
        Worker e1 = new Worker("EM001", "Sophie Anderson", validUnit);
        Worker e2 = new Worker("EM002", "Ryan Smith", validUnit);
        Worker e3 = new Worker("EM003", "Ella Miller", validUnit);
        Worker e4 = new Worker("EM004", "David Rodriguez", validUnit);
        Worker e5 = new Worker("EM005", "Grace Walker", validUnit);
        Worker e6 = new Worker("EM006", "Jordan Turner", validUnit);
    
        // Kiểm tra độ dài danh sách
        assertEquals(6, result.size());
    
        // Kiểm tra từng nhân viên trong danh sách
        assertTrue(result.contains(e1));
        assertTrue(result.contains(e2));
        assertTrue(result.contains(e3));
        assertTrue(result.contains(e4));
        assertTrue(result.contains(e5));
        assertTrue(result.contains(e6));
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
