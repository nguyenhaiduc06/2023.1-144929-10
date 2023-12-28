package com.example.pmchamcong;

import com.example.pmchamcong.service.timekeeping.report.worker.entity.WorkerTimekeepingSummary;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ImportTimekeepingLogController {
    @FXML
    private TableView<WorkerTimekeepingSummary> table;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clId;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clType;
    @FXML
    private TableColumn<WorkerTimekeepingSummary, String> clTimestamp;
    public void selectFile() {
        // 1. chọn file
        // 2. đọc dữ liệu từ file
        // 3. hiển thị dữ liệu lên bảng
    }

    public void saveData() {
        // lưu dữ liệu vào database
    }
}
