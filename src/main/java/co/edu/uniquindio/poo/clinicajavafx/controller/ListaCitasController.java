package co.edu.uniquindio.poo.clinicajavafx.controller;

import co.edu.uniquindio.poo.clinicajavafx.model.MedicalAppointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class ListaCitasController {

    @FXML
    private TableView<MedicalAppointment> tablaCitas;

    @FXML
    private TableColumn<MedicalAppointment, String> columnaPaciente;

    @FXML
    private TableColumn<MedicalAppointment, String> columnaServicio;

    @FXML
    private TableColumn<MedicalAppointment, String> columnaFecha;

    private PrincipalController principalController;

    public ListaCitasController(PrincipalController principalController) {
        this.principalController = principalController;
    }

    @FXML
    public void initialize() {
        columnaPaciente.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPacient().getName()));
        columnaServicio.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getService().getName()));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Llamar al método de PrincipalController para obtener todas las citas
        ObservableList<MedicalAppointment> appointments = principalController.getAllAppointments();
        tablaCitas.getItems().setAll(appointments);
    }
}
