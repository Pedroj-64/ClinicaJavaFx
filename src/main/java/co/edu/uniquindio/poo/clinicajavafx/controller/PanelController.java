package co.edu.uniquindio.poo.clinicajavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class PanelController {

    @FXML
    private StackPane panelPrincipal;

    private void cargarEnPanel(String rutaFXML) {
        try {
            Parent node = FXMLLoader.load(getClass().getResource("/resources/" + rutaFXML + ".fxml"));
            panelPrincipal.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarRegistroPaciente(ActionEvent actionEvent) {
        cargarEnPanel("registrarPaciente");
    }

    public void mostrarListaPacientes(ActionEvent actionEvent) {
        cargarEnPanel("listaPacientes");
    }

    public void mostrarRegistroCita(ActionEvent actionEvent) {
        cargarEnPanel("registroCita");
    }

    public void mostrarListaCitas(ActionEvent actionEvent) {
        cargarEnPanel("listaCitas");
    }
}
