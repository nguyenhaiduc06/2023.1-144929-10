package com.example.pmchamcong;

import com.example.pmchamcong.database.entity.TimekeepingLog;
import com.example.pmchamcong.database.entity.TimekeepingLogType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;

import java.io.IOException;


public class DataImportController {
    @FXML
    private TableView<TimekeepingLog> table;
    @FXML
    private TableColumn<TimekeepingLog, String> clId;
    @FXML
    private TableColumn<TimekeepingLog, LocalDateTime> clTime;
    @FXML
    private TableColumn<TimekeepingLog, TimekeepingLogType> clType;
    @FXML
    private AnchorPane ap;
    private File file;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pmchamcong";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void importFile(ActionEvent event) throws IOException {
        Connection connection = null;
        int batchSize = 20;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
            }
            String sql = "insert into timekeeping(id, timestamp, type) values(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(file));
            String lineText =  null;
            int count = 0;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String timestamp = data[1];
                String type = data[2];

                statement.setString(1, id);
                statement.setTimestamp(2, Timestamp.valueOf(timestamp));
                statement.setString(3, type);

                if(count % batchSize == 0){
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Data has been inserted successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void chooseFile (ActionEvent e) {
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a file to import");
        FileChooser.ExtensionFilter excelFilter = new FileChooser.ExtensionFilter("Excel Files", "*.xlsx", "*.xls");
        fc.getExtensionFilters().add(excelFilter);
        file = fc.showOpenDialog(stage);
    }
}