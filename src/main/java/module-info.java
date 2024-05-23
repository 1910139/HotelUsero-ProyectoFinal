module com.mycompany.hoteluseroproyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.hoteluseroproyectofinal to javafx.fxml;
    exports com.mycompany.hoteluseroproyectofinal;
}
