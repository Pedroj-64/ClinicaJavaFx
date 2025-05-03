package co.edu.uniquindio.poo.clinicajavafx.controller;

import co.edu.uniquindio.poo.clinicajavafx.model.Suscription;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrarPacienteController {

    @FXML
    private TextField lbl_nombre;

    @FXML
    private TextField lbl_id;

    @FXML
    private TextField lbl_telefono;

    @FXML
    private TextField lbl_email;

    @FXML
    private TextField lbl_suscripcion;

    @FXML
    private Button btn_guardarPaciente;

    // Instanciar PrincipalController (deberías pasar los parámetros correctos en el constructor)
    private PrincipalController principalController;

    public RegistrarPacienteController(PrincipalController principalController) {
        this.principalController = principalController;
    }

    @FXML
    public void initialize() {
        btn_guardarPaciente.setOnAction(event -> {
            principalController.registerPacient(
                    lbl_nombre.getText(),
                    lbl_id.getText(),
                    lbl_telefono.getText(),
                    lbl_email.getText(),
                    lbl_suscripcion.getText()
            );
        });
    }
}
