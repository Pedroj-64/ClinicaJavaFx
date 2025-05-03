package co.edu.uniquindio.poo.clinicajavafx.controller;

import co.edu.uniquindio.poo.clinicajavafx.services.ClinicService;
import co.edu.uniquindio.poo.clinicajavafx.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class PrincipalController {

    private ClinicService clinicService;
    private Stage stage;
    private StackPane root;
    @FXML
    private StackPane panelContenido;

    public PrincipalController(ClinicService clinicService, StackPane root, Stage stage) {
        this.clinicService = clinicService;
        this.root = root;  // Cambia a StackPane
        this.stage = stage;
    }

    // Método para obtener todas las citas médicas
    public ObservableList<MedicalAppointment> getAllAppointments() {
        return FXCollections.observableArrayList(clinicService.getAllAppointments());
    }

    // Obtener todos los pacientes
    public LinkedList<Pacient> getAllPacients() {
        return clinicService.getAllPacients();
    }

    // Obtener todos los servicios médicos
    public LinkedList<Service> getAllServices() {
        return clinicService.getAllServices();
    }

    // Registrar una cita médica
    public boolean registerMedicalAppointment(Pacient pacient, Service service, LocalDate date) {
        MedicalAppointment appointment = new MedicalAppointment(pacient, date, service);
        return clinicService.scheduleAppointment(appointment);
    }

    // Método para cargar un archivo FXML
    public void loadFXML(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            panelContenido.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Método para cargar la vista con una escena
    public void loadScene(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    // Método para registrar un paciente
    public void registerPacient(String nombre, String id, String telefono, String email, String suscripcion) {
        clinicService.registerPacient(nombre, id, telefono, email, suscripcion);
    }


    public void initData(ClinicService clinicService, StackPane root, Stage stage) {
        this.clinicService = clinicService;
        this.root = root;
        this.stage = stage;
    }
}
