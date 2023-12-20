package com.example.pmchamcong;

import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.WorkerUnit;
import com.example.pmchamcong.service.timekeeping.worker.IWorkerUnitTimekeepingReportService;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerTimekeepingResult;
import com.example.pmchamcong.service.timekeeping.worker.entity.WorkerUnitTimekeepingReport;
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
import javafx.stage.Stage;

import java.io.IOException;

public class WorkerUnitReportController {
    @FXML
    private ComboBox<WorkerUnit> cbUnits;
    @FXML
    private ComboBox<String> cbMonths;
    @FXML
    private TableView<WorkerTimekeepingResult> table;
    @FXML
    private TableColumn<WorkerTimekeepingResult, String> clId;
    @FXML
    private TableColumn<WorkerTimekeepingResult, String> clName;
    @FXML
    private TableColumn<WorkerTimekeepingResult, String> clUnit;
    @FXML
    private TableColumn<WorkerTimekeepingResult, Number> clTotalWorkHour;
    @FXML
    private TableColumn<WorkerTimekeepingResult, Number> clTotalOTHour;
    private Stage stage;
    private IHRSystem hrSystem;
    private IWorkerUnitTimekeepingReportService reportService;
    private WorkerUnitTimekeepingReport report;
    private WorkerUnit currentUnit;
    private String currentMonth;

    public void export(ActionEvent event) throws IOException {
        Stage secondStage = new Stage();

        FXMLLoader loader = new FXMLLoader(Application.class.getResource("export-worker-unit-report-view.fxml"));
        Scene scene = new Scene(loader.load());
        ExportWorkerUnitReportController controller = loader.getController();
        controller.initialize(secondStage, this.hrSystem, this.reportService);

        secondStage.setTitle("Export Timekeeping Report");
        secondStage.setScene(scene);

        stage.hide();
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
            currentUnit = observableValue.getValue();
            fetchAndDisplayData();
        }));

        ObservableList<String> months = FXCollections.observableArrayList();
        for (int i = 0; i <= 12; i++) {
            months.add(String.format("Tháng %d", i));
        }
        cbMonths.setItems(months);
        cbUnits.setOnAction(event -> {
            String selectedMonth = cbMonths.getSelectionModel().getSelectedItem();
            if (selectedMonth != null) {
                currentMonth = selectedMonth;
            }
        });
    }

    private void fetchAndDisplayData() {
            if (currentUnit == null) return;
            System.out.println("Fetching");
            System.out.println(currentUnit.getName());
            report = reportService.getReport(currentUnit);
            ObservableList<WorkerTimekeepingResult> results = FXCollections.observableArrayList(report.getResults());
            clId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getId()));
            clName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getName()));
            clUnit.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmployee().getUnit().getName()));
            clTotalWorkHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalWorkHour()));
            clTotalOTHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalOTHour()));
            table.setItems(results);
    }
}
