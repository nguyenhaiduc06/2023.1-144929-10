package com.example.pmchamcong.service.hrsystem;

import com.example.pmchamcong.entity.Department;
import com.example.pmchamcong.entity.Employee;
import com.example.pmchamcong.entity.Unit;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;

public class HRSystem implements IHRSystem {
    private final ArrayList<Employee> employees = seedEmployees();
    private final ArrayList<WorkerUnit> workerUnits = seedWorkerUnits();

    public HRSystem() {
        this.seedWorkerUnits();
        this.seedEmployees();
    }

    @Override
    public ArrayList<WorkerUnit> getAllWorkerUnits() {
        return workerUnits;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.get(1);
    }

    @Override
    public ArrayList<Employee> getEmployeesByUnit(WorkerUnit workerUnit) {
        return this.employees;
    }

    private ArrayList<WorkerUnit> seedWorkerUnits() {
        ArrayList<WorkerUnit> workerUnits = new ArrayList<>();
        WorkerUnit cn1 = new WorkerUnit("CN1");
        WorkerUnit cn2 = new WorkerUnit("CN2");
        WorkerUnit cn3 = new WorkerUnit("CN3");
        workerUnits.add(cn1);
        workerUnits.add(cn2);
        workerUnits.add(cn3);
        return workerUnits;
    }

    private ArrayList<Employee> seedEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        Department cn = new Department("Cong nhan");
        Department vp = new Department("Van phong");

        Unit marketing = new Unit("Marketing", vp);
        Unit sales = new Unit("Sales", vp);
        Unit it = new Unit("Information Technology", vp);
        Unit scm = new Unit("Supply Chain Management", cn);
        Unit fm = new Unit("Facilities Management", cn);

        Employee e1 = new Employee("EM001", "Sophie Anderson", it);
        Employee e2 = new Employee("EM002", "Ryan Smith", marketing);
        Employee e3 = new Employee("EM003", "Ella Miller", marketing);
        Employee e4 = new Employee("EM004", "David Rodriguez", sales);
        Employee e5 = new Employee("EM005", "Grace Walker", sales);
        Employee e6 = new Employee("EM006", "Jordan Turner", fm);
        Employee e7 = new Employee("EM007", "Ava Moore", fm);
        Employee e8 = new Employee("EM008", "Mason Brooks", scm);
        Employee e9 = new Employee("EM009", "Isabella Harris", fm);
        Employee e10 = new Employee("EM010", "Caleb Bennett", it);
        Employee e11 = new Employee("EM011", "Zoe Carter", it);
        Employee e12 = new Employee("EM012", "Leo Reed", fm);
        Employee e13 = new Employee("EM013", "Chloe Price", marketing);
        Employee e14 = new Employee("EM014", "Nathan King", scm);
        Employee e15 = new Employee("EM015", "Emma Cooper", sales);
        Employee e16 = new Employee("EM016", "Liam Turner", scm);
        Employee e17 = new Employee("EM017", "Mia Mitchell", scm);
        Employee e18 = new Employee("EM018", "Lucas Wright", marketing);
        Employee e19 = new Employee("EM019", "Aria Foster", it);
        Employee e20 = new Employee("EM020", "Jackson Hayes", marketing);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);
        employees.add(e9);
        employees.add(e10);
        employees.add(e11);
        employees.add(e12);
        employees.add(e13);
        employees.add(e14);
        employees.add(e15);
        employees.add(e16);
        employees.add(e17);
        employees.add(e18);
        employees.add(e19);
        employees.add(e20);

        return employees;
    }
}
