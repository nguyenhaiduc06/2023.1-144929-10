package com.example.pmchamcong.service.hrsystem;
import com.example.pmchamcong.service.hrsystem.entity.RecordReport;
import com.example.pmchamcong.service.hrsystem.entity.Worker;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;

import java.util.*;
import java.util.stream.Collectors;

public class HRSystem implements IHRSystem {
    private final ArrayList<Worker> workers = new ArrayList<>();
    private final ArrayList<WorkerUnit> workerUnits = new ArrayList<>();

    private ArrayList<RecordReport> list = new ArrayList<>();

    public HRSystem() {
        this.seed();
        this.seedAll();
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



    private void seedAll() {
        this.list.add(new RecordReport(1,"SJNP",  "Cathlene","Nhà máy sản xuất",1, 153, 10));
        this.list.add(new RecordReport(2,"KLBB",  "Allen","Nhà máy sản xuất",1, 157, 20));
        this.list.add(new RecordReport(3,"LKHO",  "Kennie","Nhà máy sản xuất",1, 164, 3));
        this.list.add(new RecordReport(4,"KLOM",  "Tanner","Nhà máy sản xuất",1, 123, 20));
        this.list.add(new RecordReport(5,"EGSC",  "Christoper","Nhà máy sản xuất",2, 142, 10));
        this.list.add(new RecordReport(6,"VNSB",  "Lewie","Nhà máy sản xuất",2, 154, 1));
        this.list.add(new RecordReport(7,"UMMS",  "Drud","Nhà máy sản xuất",2, 152, 4));

        this.list.add(new RecordReport(8,"LFAT",  "Udell","Kế toán",1, 140, 2));
        this.list.add(new RecordReport(9, "LFCI", "Tracy","Kế toán",1, 153, 3));
        this.list.add(new RecordReport( 10, "SLCH", "Dennison","Kế toán",1, 152, 9));
        this.list.add(new RecordReport( 11, "KAXV", "Hamilton","Kế toán",1, 176, 19));
        this.list.add(new RecordReport( 12, "CYPR", "Neddy","Kế toán",2, 155, 10));
        this.list.add(new RecordReport( 13, "YMGT", "Cletis","Kế toán",2, 160, 13));
        this.list.add(new RecordReport( 14, "KIWS", "Charla","Kế toán",2, 137, 10));

        this.list.add(new RecordReport( 15, "BIHU", "Brit","Hệ thống",1, 187, 7));
        this.list.add(new RecordReport( 16, "OETR", "Galvan","Hệ thống",1, 158, 7));
        this.list.add(new RecordReport( 17, "VYPA" ,"Kanya","Hệ thống",1, 136, 11));
        this.list.add(new RecordReport( 18, "KHQM" ,"Ayn","Hệ thống",1, 169, 12));
        this.list.add(new RecordReport( 19, "DFOD" ,"Horten","Hệ thống",2, 156, 2));
        this.list.add(new RecordReport( 20, "ZSAM" ,"Jaime","Hệ thống",2, 152, 5));
        this.list.add(new RecordReport( 21, "CYLQ" ,"Michaella","Hệ thống",2, 139, 13));

        this.list.add(new RecordReport( 22, "SVVA", "Orran","Nhân sự",1, 179, 8));
        this.list.add(new RecordReport( 23, "CYBB", "Damon","Nhân sự",1, 200, 17));
        this.list.add(new RecordReport( 24, "KCRW", "Editha","Nhân sự",1, 179, 5));
        this.list.add(new RecordReport( 25, "AYTN", "Janenna","Nhân sự",1, 150, 1));
        this.list.add(new RecordReport( 26, "LTBZ", "Lyman","Nhân sự",2, 157, 8));
        this.list.add(new RecordReport( 27, "PAGQ", "Karole","Nhân sự",2, 141, 10));
        this.list.add(new RecordReport( 28, "RPVE", "Laverne","Nhân sự",2, 173, 1));

    }

    @Override
    public Set<String> getAllDepartmentName() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < this.list.size(); i++)
            set.add(this.list.get(i).getDepartment());
        return set;
    }

    @Override
    public List<RecordReport> getAllByDepartmentName(String departmentName, Integer month) {
        List<RecordReport> res = new ArrayList<>();
        for (RecordReport x : this.list) {
            if (x.getDepartment().equals(departmentName)) {
                if (x.getMonth() % 2 == month%2) {
                    res.add(x);
                }
            }
        }
        return  res;
    }
}

























