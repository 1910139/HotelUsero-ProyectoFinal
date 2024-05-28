module com.mycompany.hoteluseroproyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires MiLibreria2023;
//    requires MySQL;
//    requires java.sql;
//    requires java.desktop;


    opens com.mycompany.hoteluseroproyectofinal to javafx.fxml;
    exports com.mycompany.hoteluseroproyectofinal;
}
