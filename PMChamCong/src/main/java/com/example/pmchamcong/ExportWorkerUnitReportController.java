package com.example.pmchamcong;

import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.csv.CSVManipulator;
import com.example.pmchamcong.service.excel.ExcelManipulator;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.worker.IWorkerUnitTimekeepingReportService;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerTimekeepingResult;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerUnitTimekeepingReport;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ExportWorkerUnitReportController {
    @FXML
    private ComboBox<WorkerUnit> cbUnits;
    @FXML
    private ComboBox<String> cbMonths;
    @FXML
    private ComboBox<String> cbFormat;
    private Stage stage;
    private IHRSystem hrSystem;
    private IWorkerUnitTimekeepingReportService reportService;
    private WorkerUnitTimekeepingReport report;
    private WorkerUnit selectedUnit;
    private String selectedMonth;
    private String selectedFormat;
    private String selectedFolder;

    public void initialize(Stage stage, IHRSystem hrSystem, IWorkerUnitTimekeepingReportService reportService) {
        this.stage = stage;
        this.hrSystem = hrSystem;
        this.reportService = reportService;
        populateComboBoxes();
    }

    public void choseDirectory() {
        // Create a DirectoryChooser
        DirectoryChooser directoryChooser = new DirectoryChooser();

        // Set the title for the dialog
        directoryChooser.setTitle("Select Folder");

        // Set the initial directory (optional)
        // directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Show the folder chooser dialog
        File selectedDirectory = directoryChooser.showDialog(stage);

        // Check if a folder was selected
        if (selectedDirectory != null) {
            // Perform actions with the selected folder
            System.out.println("Folder selected: " + selectedDirectory.getAbsolutePath());
        } else {
            System.out.println("No folder selected.");
        }
    }

    public void export() {
        if (Objects.equals(selectedFormat, "CSV")) {
            CSVData data = reportService.createCSVData(report);
            CSVManipulator.exportDataToCSV(data, selectedFolder + "Report");
        }
        if (Objects.equals(selectedFormat, "XLS")) {
            XLSData data = reportService.createXLSData(report);
            ExcelManipulator.exportDataToXLSX(data, "Report");
        }
    }

    private void populateComboBoxes() {
        ObservableList<WorkerUnit> workerUnits = FXCollections.observableArrayList(hrSystem.getAllWorkerUnits());
        cbUnits.setItems(workerUnits);
        cbUnits.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedUnit = observableValue.getValue();
            fetchAndDisplayData();
        }));

        ObservableList<String> months = FXCollections.observableArrayList();
        for (int i = 0; i <= 12; i++) {
            months.add(String.format("Tháng %d", i));
        }
        cbMonths.setItems(months);
        cbMonths.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedMonth = observableValue.getValue();
            fetchAndDisplayData();
        }));

        cbFormat.setItems(FXCollections.observableArrayList("CSV", "XLS"));
        cbFormat.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedFormat = observableValue.getValue();
        }));
    }

    private void fetchAndDisplayData() {
        if (selectedUnit == null) return;
        System.out.println("Fetching");
        System.out.println(selectedUnit.getName());
        report = reportService.getReport(selectedUnit);
        ObservableList<WorkerTimekeepingResult> results = FXCollections.observableArrayList(report.getResults());
//        clId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getId()));
//        clName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getName()));
//        clUnit.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getUnit().getName()));
//        clTotalWorkHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalWorkHour()));
//        clTotalOTHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalOTHour()));
//        table.setItems(results);
    }
}
