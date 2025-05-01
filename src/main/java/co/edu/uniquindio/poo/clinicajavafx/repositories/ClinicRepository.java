package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Clinic;
import co.edu.uniquindio.poo.clinicajavafx.model.MedicalAppointment;
import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;

import java.util.LinkedList;
import java.util.Optional;

public class ClinicRepository {

    private Clinic Clinic;
    private LinkedList<MedicalAppointment> medicalAppointments;
    private LinkedList<Service> services;
    private LinkedList<Pacient> pacients;

    public ClinicRepository() {
        this.medicalAppointments = new LinkedList<>();
        this.services = new LinkedList<>();
        this.pacients = new LinkedList<>();

    }

    public void saveClinic(Clinic clinic){this.Clinic=clinic;}

    public Optional<Clinic> getClinic(){return Optional.ofNullable(this.Clinic);}

    public void deleteClinic(Clinic clinic){this.Clinic=null;}

}
