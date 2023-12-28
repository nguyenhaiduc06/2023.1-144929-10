package com.example.pmchamcong;

import com.example.pmchamcong.database.Database;
import com.example.pmchamcong.database.IDatabase;
import com.example.pmchamcong.service.hrsystem.HRSystem;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.timekeeping.report.worker.IWorkerUnitReportService;
import com.example.pmchamcong.service.timekeeping.report.worker.WorkerUnitReportService;
import com.example.pmchamcong.service.timekeeping.result.IResultService;
import com.example.pmchamcong.service.timekeeping.result.ResultService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainController {
    private final IHRSystem hrSystem = new HRSystem();
    private final IResultService resultService = new ResultService();
    private final IDatabase database = new Database();
    private final IWorkerUnitReportService workerUnitReportService = new WorkerUnitReportService(hrSystem);
    private Stage primaryStage;
    @FXML
    private BorderPane borderPane;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void viewTrangChu(ActionEvent actionEvent) {

    }

    public void importDataReport(ActionEvent actionEvent) {
        URL fxmlUrl = Application.class.getResource("data-import-view.fxml");
        if (fxmlUrl != null) {
            DataImportController controller = navigate(fxmlUrl);
        } else {
            System.err.println("FXML file not found!");
        }
    }

    public void viewWorkerUnitTimekeepingReport(ActionEvent actionEvent) throws IOException {
        WorkerUnitReportController controller = navigate(Application.class.getResource("worker-unit-report-view.fxml"));
        controller.initialize(primaryStage, this.hrSystem, this.workerUnitReportService);
    }

    public void viewDepartmentReport(ActionEvent actionEvent) {
        DepartmentReportController controller = navigate(Application.class.getResource("department-report-view.fxml"));
        controller.initialize(primaryStage, this.hrSystem);
    }
    private <T> T navigate(URL url) {
        try {
            Parent root = null;
            FXMLLoader loader = new FXMLLoader(url);
            root = loader.load();
            borderPane.setCenter(null);
            borderPane.setCenter(root);
            return loader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
