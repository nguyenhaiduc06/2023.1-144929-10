package com.example.pmchamcong;

import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.report.worker.IWorkerUnitTimekeepingReportService;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerTimekeepingSummary;
import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerUnitTimekeepingReport;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Month;

public class WorkerUnitReportController {
    @FXML
    private ComboBox<WorkerUnit> cbUnits;
    @FXML
    private ComboBox<Month> cbMonths;
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

    public void export(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();

        FXMLLoader loader = new FXMLLoader(Application.class.getResource("export-worker-unit-report-view.fxml"));
        Scene scene = new Scene(loader.load());
        ExportWorkerUnitReportController controller = loader.getController();
        controller.initialize(secondStage, this.hrSystem, this.reportService);
        if (selectedUnit != null) controller.selectDefaultUnit(selectedUnit);
        if (selectedMonth != null) controller.selectDefaultMonth(selectedMonth);

        secondStage.initModality(Modality.APPLICATION_MODAL);
        secondStage.setTitle("Xuất báo cáo");
        secondStage.setScene(scene);

        secondStage.show();
    }

    public void initialize(Stage stage, IHRSystem hrSystem, IWorkerUnitTimekeepingReportService reportService) {
        this.stage = stage;
        this.hrSystem = hrSystem;
        this.reportService = reportService;
        populateComboBoxes();
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
