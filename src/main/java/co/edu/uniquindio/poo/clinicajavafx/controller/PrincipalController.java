package co.edu.uniquindio.poo.clinicajavafx.controller;

import co.edu.uniquindio.poo.clinicajavafx.ClinicApplication;
import co.edu.uniquindio.poo.clinicajavafx.model.Clinic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.io.IOException;

public class PrincipalController {

    private static Scene mainScene;
    private static final Clinic clinic = new Clinic(); 

    public static Clinic getClinic() {
        return clinic;
    }

    public static void setScene(Scene scene) {
        mainScene = scene;
    }

    public static void loadScene(String fxml, double width, double height) {
        try {
            Parent root = loadFXML(fxml);
            mainScene.setRoot(root);
            mainScene.getWindow().setWidth(width);
            mainScene.getWindow().setHeight(height);
        } catch (IOException e) {
            showAlert("Error al cambiar la vista", "No se pudo cargar el archivo FXML: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(ClinicApplication.class.getResource("/co/edu/uniquindio/poo/clinicajavafx/" + fxml + ".fxml"));
        return loader.load();
    }

    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showAlertAndRedirect(String title, String message, Alert.AlertType type, String fxml,
                                            double width, double height) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setOnHidden(evt -> loadScene(fxml, width, height));
        alert.show();
    }
}
