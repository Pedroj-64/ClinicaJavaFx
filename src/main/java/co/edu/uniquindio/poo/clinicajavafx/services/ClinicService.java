package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.*;
import co.edu.uniquindio.poo.clinicajavafx.model.factory.SuscriptionFactory;
import co.edu.uniquindio.poo.clinicajavafx.repositories.ClinicRepository;

import java.util.LinkedList;
import java.util.Optional;

public class ClinicService {
    ClinicRepository clinicRepository;
    ClinicService medicalAppointmentService;
    BillService billService;

    public void registerPacient(String phoneNumber, String name, String email, String id, String tipoSuscripcion) {

        Optional<Pacient> existingPacient = clinicRepository.getAllPacients().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existingPacient.isPresent()) {
            return;
        }

        Suscription suscription = SuscriptionFactory.createSuscription(tipoSuscripcion);

        Pacient pacient = Pacient.builder()
                .phoneNumber(phoneNumber)
                .name(name)
                .email(email)
                .id(id)
                .suscription(suscription)
                .build();

        clinicRepository.savePacient(pacient);
    }

    public boolean scheduleAppointment(MedicalAppointment appointment) {

        return medicalAppointmentService.scheduleAppointment(appointment);
    }

    public Bill generateBillForPacient(Pacient pacient, MedicalAppointment appointment) {
        double subtotal = appointment.getService().getPrice();
        double total = subtotal;
        return billService.createBill(subtotal, total);
    }

    public LinkedList<Service> getAllServices() {
        return clinicRepository.getAllServices();
    }

    public LinkedList<Pacient> getAllPacients() {
        return clinicRepository.getAllPacients();
    }

    public LinkedList<MedicalAppointment> getAllAppointments() {
        return clinicRepository.getAllAppointments();
    }
}
