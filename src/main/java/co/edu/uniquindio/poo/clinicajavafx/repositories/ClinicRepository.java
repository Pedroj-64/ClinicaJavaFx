// repository/ClinicRepository.java
package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.*;

import java.util.LinkedList;

public class ClinicRepository {

    private final Clinic clinic;

    public ClinicRepository() {
        this.clinic = new Clinic();
    }

   
    public void savePacient(Pacient pacient) {
        clinic.getPacients().add(pacient);
    }

    public LinkedList<Pacient> getAllPacients() {
        return clinic.getPacients();
    }

    public void deletePacient(Pacient pacient) {
        clinic.getPacients().remove(pacient);
    }

   
    public void saveService(Service service) {
        clinic.getServices().add(service);
    }

    public LinkedList<Service> getAllServices() {
        return clinic.getServices();
    }

    public void deleteService(Service service) {
        clinic.getServices().remove(service);
    }

 
    public void saveAppointment(MedicalAppointment appointment) {
        clinic.getMedicalAppointments().add(appointment);
    }

    public LinkedList<MedicalAppointment> getAllAppointments() {
        return clinic.getMedicalAppointments();
    }

    public void deleteAppointment(MedicalAppointment appointment) {
        clinic.getMedicalAppointments().remove(appointment);
    }

    
    public Clinic getClinic() {
        return clinic;
    }
}

