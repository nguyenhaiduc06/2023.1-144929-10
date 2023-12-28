package com.example.pmchamcong;

import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.hrsystem.entity.RecordReport;
import com.example.pmchamcong.service.hrsystem.entity.RecordReportSummary;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartmentReportController {

    private Stage stage;
    private IHRSystem hrSystem;

    @FXML
    private ComboBox<Integer> cbMonths;

    @FXML
    private ComboBox<String> cbDepartmentNames;

    @FXML
    private TableColumn<RecordReport, String> clName;
    @FXML
    private TableColumn<RecordReport, String> clUnit;
    @FXML
    private TableColumn<RecordReport, Number> clTotalWorkHour;
    @FXML
    private TableColumn<RecordReport, Number> clTotalLateHour;

    @FXML
    private TableView<RecordReport> table;

    @FXML
    private TableColumn<RecordReport, String> clId;

    @FXML
    private TableView<RecordReportSummary> table2;

    @FXML
    private TableColumn<RecordReportSummary, Number> count;

    @FXML
    private TableColumn<RecordReportSummary, Number> totalWork;

    @FXML
    private TableColumn<RecordReportSummary, Number> totalLate;

    private Integer selectedMonth;
    private String selectedDepartment;

    public void initialize(Stage primaryStage, IHRSystem hrSystem) {
        this.stage = stage;
        this.hrSystem = hrSystem;
        populateComboBoxes();
    }

    private void populateComboBoxes() {
        ObservableList<String> departmentNames = FXCollections.observableArrayList(hrSystem.getAllDepartmentName());
        cbDepartmentNames.setItems(departmentNames);
        cbDepartmentNames.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            selectedDepartment = observableValue.getValue();
            fetchAndDisplayData();
        });

        ObservableList<Integer> months = FXCollections.observableArrayList();
        for (int i = 1; i <= LocalDateTime.now().getMonthValue(); i++)
            months.add(i);
        cbMonths.setItems(months);
        cbMonths.valueProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedMonth = observableValue.getValue();
            fetchAndDisplayData();
        }));
    }

    private void fetchAndDisplayData() {
        System.out.println(selectedMonth);
        System.out.println(selectedDepartment);
        if (selectedDepartment != null && selectedMonth != null) {
            List<RecordReport> recordList = hrSystem.getAllByDepartmentName(selectedDepartment, selectedMonth);
            ObservableList<RecordReport> results = FXCollections.observableArrayList(recordList);
            clId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCode()));
            clName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFullname()));
            clUnit.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDepartment()));
            clTotalWorkHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getWorkHour()));
            clTotalLateHour.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getLateHour()));
            table.setItems(results);

            List<RecordReportSummary> recordList2 = new ArrayList<>();

            int y = 0;
            int x = 0;
            for (int i = 0; i < recordList.size(); i++) {
                {
                    x += recordList.get(i).getWorkHour();
                    y += recordList.get(i).getLateHour();
                }
            }
            recordList2.add(new RecordReportSummary(recordList.size(), x, y));
            ObservableList<RecordReportSummary> result2 = FXCollections.observableArrayList(recordList2);
            this.count.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCount()));
            this.totalWork.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalWork()));
            this.totalLate.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getTotalLate()));
            table2.setItems(result2);
        }
    }
}
