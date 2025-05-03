package co.edu.uniquindio.poo.clinicajavafx.controllers;

import co.edu.uniquindio.poo.clinicajavafx.controller.PrincipalController;
import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class CrearCitaController {

    @FXML
    private ComboBox<Pacient> comboPacientes;

    @FXML
    private ComboBox<Service> comboServicios;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label labelMensaje;

    private PrincipalController principalController;

    // Constructor para inyectar el PrincipalController
    public CrearCitaController(PrincipalController principalController) {
        this.principalController = principalController;
    }

    @FXML
    public void initialize() {
        comboPacientes.getItems().setAll(principalController.getAllPacients());
        comboServicios.getItems().setAll(principalController.getAllServices());
    }

    @FXML
    public void registrarCita() {
        Pacient paciente = comboPacientes.getValue();
        Service servicio = comboServicios.getValue();
        LocalDate fecha = datePicker.getValue();

        if (paciente == null || servicio == null || fecha == null) {
            labelMensaje.setText("Todos los campos son obligatorios");
            return;
        }

        boolean exito = principalController.registerMedicalAppointment(paciente, servicio, fecha);

        if (exito) {
            labelMensaje.setText("Cita registrada exitosamente");
        } else {
            labelMensaje.setText("No se pudo registrar la cita. Ya hay una en esa fecha.");
        }
    }
}
