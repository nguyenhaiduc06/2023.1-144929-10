module com.example.pmchamcong {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.opencsv;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires mysql.connector.j;


    opens com.example.pmchamcong to javafx.fxml;
    exports com.example.pmchamcong;
}