module com.example.logindatabasegx {
    requires javafx.controls;
    requires javafx.fxml;
    //for Database connetions
    requires java.sql;


    opens com.example.logindatabasegx to javafx.fxml;
    exports com.example.logindatabasegx;
    exports com.example.logindatabasegx.Controller;
    opens com.example.logindatabasegx.Controller to javafx.fxml;
    exports com.example.logindatabasegx.Model;
    opens com.example.logindatabasegx.Model to javafx.fxml;
}