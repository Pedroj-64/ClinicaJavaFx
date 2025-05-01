package co.edu.uniquindio.poo.clinicajavafx.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;


public class PanelController {


    @FXML
    private StackPane panelPrincipal;


    public void mostrarRegistroPaciente(ActionEvent actionEvent) {
        Parent node = cargarPanel("/registroPaciente.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }


    public void mostrarListaPacientes(ActionEvent actionEvent) {
        Parent node = cargarPanel("/ListPacients.fxml");


        // Se reemplaza el contenido del panel principal
        panelPrincipal.getChildren().setAll(node);
    }


    public void mostrarRegistroCita(ActionEvent actionEvent) {
        //Completar
    }


    public void mostrarListaCitas(ActionEvent actionEvent) {
        //Completar
    }


    private Parent cargarPanel(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent node = loader.load();
            return node;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
