module co.edu.uniquindio.poo.clinicajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires static lombok;


    opens co.edu.uniquindio.poo.clinicajavafx to javafx.fxml;
    exports co.edu.uniquindio.poo.clinicajavafx;
    exports co.edu.uniquindio.poo.clinicajavafx.model;
    opens co.edu.uniquindio.poo.clinicajavafx.model to javafx.fxml;
}