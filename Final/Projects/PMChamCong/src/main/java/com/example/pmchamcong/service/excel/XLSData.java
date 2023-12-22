package com.example.pmchamcong.service.excel;

import java.util.ArrayList;

public class XLSData {
    private String[] header;
    private ArrayList<String[]> rows;
    public XLSData(String[] header, ArrayList<String[]> rows) {
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
