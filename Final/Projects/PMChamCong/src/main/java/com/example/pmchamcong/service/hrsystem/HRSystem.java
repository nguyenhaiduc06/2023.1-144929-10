package com.example.pmchamcong.service.hrsystem;
import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class HRSystem implements IHRSystem {
    private final ArrayList<Worker> workers = new ArrayList<>();
    private final ArrayList<WorkerUnit> workerUnits = new ArrayList<>();

    public HRSystem() {
        this.seed();
    }

    @Override
    public ArrayList<WorkerUnit> getAllWorkerUnits() {
        return workerUnits;
    }


    @Override
    public ArrayList<Worker> getEmployeesByUnit(WorkerUnit workerUnit) {
        ArrayList<Worker> filteredWorkers = new ArrayList<>();
        for (Worker worker: workers) {
            if (Objects.equals(worker.getUnit().getName(), workerUnit.getName())) {
                filteredWorkers.add(worker);
            }
        }
        return filteredWorkers;

    }
    private void seed() {
        WorkerUnit cn1 = new WorkerUnit("CN1");
        WorkerUnit cn2 = new WorkerUnit("CN2");
        WorkerUnit cn3 = new WorkerUnit("CN3");
        workerUnits.add(cn1);
        workerUnits.add(cn2);
        workerUnits.add(cn3);

        Worker e1 = new Worker("EM001", "Sophie Anderson", cn1);
        Worker e2 = new Worker("EM002", "Ryan Smith", cn1);
        Worker e3 = new Worker("EM003", "Ella Miller", cn1);
        Worker e4 = new Worker("EM004", "David Rodriguez", cn1);
        Worker e5 = new Worker("EM005", "Grace Walker", cn1);
        Worker e6 = new Worker("EM006", "Jordan Turner", cn1);
        Worker e7 = new Worker("EM007", "Ava Moore", cn2);
        Worker e8 = new Worker("EM008", "Mason Brooks", cn2);
        Worker e9 = new Worker("EM009", "Isabella Harris", cn2);
        Worker e10 = new Worker("EM010", "Caleb Bennett", cn2);
        Worker e11 = new Worker("EM011", "Zoe Carter", cn2);
        Worker e12 = new Worker("EM012", "Leo Reed", cn2);
        Worker e13 = new Worker("EM013", "Chloe Price", cn3);
        Worker e14 = new Worker("EM014", "Nathan King", cn3);
        Worker e15 = new Worker("EM015", "Emma Cooper", cn3);
        Worker e16 = new Worker("EM016", "Liam Turner", cn3);
        Worker e17 = new Worker("EM017", "Mia Mitchell", cn3);
        Worker e18 = new Worker("EM018", "Lucas Wright", cn3);
        Worker e19 = new Worker("EM019", "Aria Foster", cn3);
        Worker e20 = new Worker("EM020", "Jackson Hayes", cn3);
        workers.add(e1);
        workers.add(e2);
        workers.add(e3);
        workers.add(e4);
        workers.add(e5);
        workers.add(e6);
        workers.add(e7);
        workers.add(e8);
        workers.add(e9);
        workers.add(e10);
        workers.add(e11);
        workers.add(e12);
        workers.add(e13);
        workers.add(e14);
        workers.add(e15);
        workers.add(e16);
        workers.add(e17);
        workers.add(e18);
        workers.add(e19);
        workers.add(e20);
    }
}
