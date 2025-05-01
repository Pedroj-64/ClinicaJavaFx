package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.MedicalAppointment;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class MedicalAppointmentRepository {

    private final LinkedList<MedicalAppointment> medicalAppointments;

    public MedicalAppointmentRepository() {this.medicalAppointments = new LinkedList<>();}

    public void save(MedicalAppointment medicalAppointment) {medicalAppointments.add(medicalAppointment);}

    public Optional<MedicalAppointment> getMedicalAppointment(UUID medicalAppointmentId) {
        return medicalAppointments.stream().filter(m -> m.getId().equals(medicalAppointmentId)).findFirst();
    }

    public void delete(UUID medicalAppointmentId) {medicalAppointments.removeIf(m -> m.getId().equals(medicalAppointmentId));}
    
}
