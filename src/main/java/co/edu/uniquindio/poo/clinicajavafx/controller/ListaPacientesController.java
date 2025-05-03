package co.edu.uniquindio.poo.clinicajavafx.controller;

import co.edu.uniquindio.poo.clinicajavafx.controller.PrincipalController;
import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaPacientesController {

    private PrincipalController principalController;

    @FXML
    private TableView<Pacient> tablaPacientes;

    @FXML
    private TableColumn<Pacient, String> columnaNombre;

    @FXML
    private TableColumn<Pacient, String> columnaEmail;

    @FXML
    private TableColumn<Pacient, String> columnaId;

    public void setPrincipalController(PrincipalController principalController) {
        this.principalController = principalController;
        cargarPacientes(); // Cargar la tabla cuando se setea el controlador
    }

    @FXML
    public void initialize() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    public void cargarPacientes() {
        if (principalController != null) {
            tablaPacientes.getItems().setAll(principalController.getAllPacients());
        }
    }
}
