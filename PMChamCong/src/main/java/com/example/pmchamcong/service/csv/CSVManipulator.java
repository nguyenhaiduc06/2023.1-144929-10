package com.example.pmchamcong.service.csv;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVManipulator {
    public static void exportDataToCSV(CSVData data, String fileName) {
        String filePath = fileName + ".csv";
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

            System.out.println("Successfully exported data to CSV file");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
