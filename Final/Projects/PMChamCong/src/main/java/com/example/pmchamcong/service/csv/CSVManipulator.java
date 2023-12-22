package com.example.pmchamcong.service.csv;

import com.opencsv.CSVWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVManipulator {
    public static void exportDataToCSV(CSVData data, String filePath) {
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            writer.writeNext(data.getHeader());

            for (String[] row:data.getRows()) {
                writer.writeNext(row);
            }

            // closing writer connection
            writer.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully exported data to " + filePath, ButtonType.OK);
            alert.showAndWait();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
