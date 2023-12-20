package com.example.pmchamcong;

import com.example.pmchamcong.service.csv.CSVData;
import com.example.pmchamcong.service.csv.CSVManipulator;
import com.example.pmchamcong.service.excel.ExcelManipulator;
import com.example.pmchamcong.service.excel.XLSData;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.report.worker.IWorkerUnitTimekeepingReportService;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerTimekeepingSummary;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitTimekeepingReport;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.Month;
import java.util.Objects;

public class ExportWorkerUnitReportController {
    @FXML
    private ComboBox<WorkerUnit> cbUnits;
    @FXML
    private ComboBox<Month> cbMonths;
    @FXML
    private ComboBox<String> cbFormat;
    @FXML
    private Label lbFolder;
    @FXML
    private TableView<WorkerTimekeepingSummary> table;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clId;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clName;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clUnit;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, Number> clTotalWorkHour;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, Number> clTotalOTHour;
    private Stage stage;
    private IHRSystem hrSystem;
    private IWorkerUnitTimekeepingReportService reportService;
    private WorkerUnitTimekeepingReport report;
    private WorkerUnit selectedUnit;
    private Month selectedMonth;
    private String selectedFormat;
    private String selectedFolder;

    public void initialize(Stage stage, IHRSystem hrSystem, IWorkerUnitTimekeepingReportService reportService) {
        this.stage = stage;
        this.hrSystem = hrSystem;
        this.reportService = reportService;
        populateComboBoxes();
    }
    public void selectDefaultUnit(WorkerUnit unit) {
        cbUnits.setValue(unit);
    }
    public void selectDefaultMonth(Month month) {
        cbMonths.setValue(month);
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
            selectedFolder = selectedDirectory.getAbsolutePath();
            lbFolder.setText(selectedFolder);
            System.out.println("Folder selected: " + selectedDirectory.getAbsolutePath());
        } else {
            System.out.println("No folder selected.");
        }
    }

    public void export() {
        if (Objects.equals(selectedFormat, "CSV")) {
            CSVData data = reportService.createCSVData(report);
            CSVManipulator.exportDataToCSV(data, selectedFolder + "/Report.csv");
        }
        if (Objects.equals(selectedFormat, "XLS")) {
            XLSData data = reportService.createXLSData(report);
            ExcelManipulator.exportDataToXLSX(data, selectedFolder + "Report.xls");
        }
    }

    private void populateComboBoxes() {
        ObservableList<WorkerUnit> workerUnits = FXCollections.observableArrayList(hrSystem.getAllWorkerUnits());
        cbUnits.setItems(workerUnits);
        cbUnits.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedUnit = observableValue.getValue();
            fetchAndDisplayData();
        }));

        ObservableList<Month> months = FXCollections.observableArrayList();
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
        cbMonths.setItems(months);
        cbMonths.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedMonth = observableValue.getValue();
            fetchAndDisplayData();
        }));

        cbFormat.setItems(FXCollections.observableArrayList("CSV", "XLS"));
        cbFormat.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedFormat = observableValue.getValue();
        }));
        cbFormat.setValue("CSV");
    }

    private void fetchAndDisplayData() {
        if (selectedUnit == null || selectedMonth == null) return;
        report = reportService.getReport(selectedUnit, selectedMonth);
        ObservableList<WorkerTimekeepingSummary> results = FXCollections.observableArrayList(report.getSummaries());
        clId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getId()));
        clName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getName()));
        clUnit.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getUnit().getName()));
        clTotalWorkHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalWorkHour()));
        clTotalOTHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalOTHour()));
        table.setItems(results);
    }
}
