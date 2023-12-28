package com.example.pmchamcong;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.pmchamcong.database.entity.TimekeepingLog;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFromExcelFile {

    public List<TimekeepingLog> readDataFromExcelFile(String excelFilePath) throws IOException {
        List<TimekeepingLog> listLogs = new ArrayList<TimekeepingLog>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workBook = getWorkbook(inputStream, excelFilePath);
        Sheet firstSheet = workBook.getSheetAt(0);
        Iterator<Row> rows = firstSheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            TimekeepingLog log = new TimekeepingLog();

            while (cells.hasNext()) {
                Cell cell = cells.next();
                int columnIndex = cell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        log.setEmployeeId((String) getCellValue(cell));
                        break;
                    case 1:
                        log.setTimestamp(LocalDateTime.parse((String) getCellValue(cell)));
                        break;
                    case 2:
                        log.setType((String) getCellValue(cell));
                        break;
                }
            }
            listLogs.add(log);
        }

        workBook.close();
        inputStream.close();

        return listLogs;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }

    private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

}
