package com.example.pmchamcong;

import com.example.pmchamcong.service.hrsystem.HRSystem;
import com.example.pmchamcong.service.hrsystem.IHRSystem;
import com.example.pmchamcong.service.timekeeping.log.ILogService;
import com.example.pmchamcong.service.timekeeping.log.LogService;
import com.example.pmchamcong.service.timekeeping.worker.IWorkerUnitTimekeepingReportService;
import com.example.pmchamcong.service.timekeeping.worker.WorkerUnitTimekeepingReportService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private final IHRSystem hrSystem = new HRSystem();
    private final ILogService logService = new LogService();
    private final IWorkerUnitTimekeepingReportService workerUnitReportService = new WorkerUnitTimekeepingReportService(hrSystem, logService);
    private Stage primaryStage;
    @FXML
    private BorderPane borderPane;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void viewTrangChu(ActionEvent actionEvent) {

    }

    public void viewWorkerUnitTimekeepingReport(ActionEvent actionEvent) throws IOException {
        Stage secondStage = new Stage();

        FXMLLoader loader = new FXMLLoader(Application.class.getResource("worker-unit-report-view.fxml"));
        Scene scene = new Scene(loader.load());
        WorkerUnitReportController controller = loader.getController();
        controller.initialize(secondStage, this.hrSystem, this.workerUnitReportService);

        secondStage.setTitle("Timekeeping Report");
        secondStage.setScene(scene);

        primaryStage.hide();
        secondStage.show();
    }
}
