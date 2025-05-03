package co.edu.uniquindio.poo.clinicajavafx;

import co.edu.uniquindio.poo.clinicajavafx.controller.PanelController;
import co.edu.uniquindio.poo.clinicajavafx.services.ClinicService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClinicApplication extends Application {

    private final ClinicService clinicService = new ClinicService();

    @Override
    public void start(Stage stage) throws Exception {
        // Cargar la vista principal desde el FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/panel.fxml"));
        StackPane root = loader.load(); // Cargar el panel principal

        // Obtener el controlador del panel (si es necesario)
        PanelController panelController = loader.getController();
        // Aquí no necesitas pasarle datos, solo se carga la vista

        // Crear y mostrar la escena
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Clínica JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
