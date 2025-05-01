package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.MedicalAppointment;

import java.util.LinkedList;

public class MedicalAppointmentRepository {

    private final LinkedList<MedicalAppointment> medicalAppointments;

    public MedicalAppointmentRepository() {
        this.medicalAppointments = new LinkedList<>();
    }

    public void save(MedicalAppointment appointment) {
        medicalAppointments.add(appointment);
    }

    public LinkedList<MedicalAppointment> getAll() {
        return medicalAppointments;
    }

    public void delete(MedicalAppointment appointment) {
        medicalAppointments.remove(appointment);
    }

    public boolean exists(MedicalAppointment appointment) {
        return medicalAppointments.contains(appointment);
    }
}
