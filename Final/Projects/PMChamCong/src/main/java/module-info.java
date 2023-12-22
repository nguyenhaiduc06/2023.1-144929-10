module com.example.pmchamcong {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.opencsv;
    requires org.apache.poi.poi;


    opens com.example.pmchamcong to javafx.fxml;
    exports com.example.pmchamcong;
}