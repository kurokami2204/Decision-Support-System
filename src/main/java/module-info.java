module com.example.hetrogiupluachonmonan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hetrogiupluachonmonan to javafx.fxml;
    exports com.example.hetrogiupluachonmonan;
}