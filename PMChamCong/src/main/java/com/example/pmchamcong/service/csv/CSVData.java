package com.example.pmchamcong.service.csv;

import java.util.ArrayList;

public class CSVData {
    private String[] header;
    private ArrayList<String[]> rows;
    public CSVData(String[] header, ArrayList<String[]> rows) {
        this.header = header;
        this.rows = rows;
    }

    public String[] getHeader() {
        return header;
    }

    public ArrayList<String[]> getRows() {
        return rows;
    }
}
