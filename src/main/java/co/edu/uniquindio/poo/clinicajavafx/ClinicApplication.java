package co.edu.uniquindio.poo.clinicajavafx;

import co.edu.uniquindio.poo.clinicajavafx.controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClinicApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/clinicajavafx/hello-view.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        stage.setTitle("Clínica JavaFX");
        stage.setScene(scene);
        stage.show();

        PrincipalController.setScene(scene); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
