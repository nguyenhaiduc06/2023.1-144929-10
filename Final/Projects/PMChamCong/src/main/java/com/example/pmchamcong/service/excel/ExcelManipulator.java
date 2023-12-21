package com.example.pmchamcong.service.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelManipulator {
    public static void exportDataToXLSX(XLSData data, String filePath) {
        try {
            // create a new file
            FileOutputStream out = new FileOutputStream(filePath);
            // create a new workbook
            Workbook wb = new HSSFWorkbook();
            // create a new sheet
            Sheet s = wb.createSheet();

            // declare a row object reference
            Row r = null;
            // declare a cell object reference
            Cell c = null;

            // create a sheet with 30 rows (0-29)
            int rownum;
            for (rownum = (short) 0; rownum < data.getRows().size(); rownum++) {
                // create a row
                r = s.createRow(rownum);
                // create 10 cells (0-9) (the += 2 becomes apparent later
                for (short cellnum = (short) 0; cellnum < data.getRows().get(rownum).length; cellnum += 1) {
                    // create a numeric cell
                    c = r.createCell(cellnum);
                    // do some goofy math to demonstrate decimals
                    c.setCellValue(data.getRows().get(rownum)[cellnum]);
                }
            }

            wb.write(out);
            out.close();

            System.out.println("Successfully exported data to XLS file");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
