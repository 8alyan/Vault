module com.example.jattdamukabla {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jattdamukabla to javafx.fxml;
    exports com.example.jattdamukabla;
}