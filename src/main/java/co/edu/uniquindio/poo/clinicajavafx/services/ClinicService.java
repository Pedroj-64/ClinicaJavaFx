// service/ClinicService.java
package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.*;
import co.edu.uniquindio.poo.clinicajavafx.repositories.ClinicRepository;

import java.util.LinkedList;
import java.util.Optional;

public class ClinicService {

    private final ClinicRepository clinicRepository;
    private final MedicalAppointmentServices medicalAppointmentService;
    private final BillService billService;

    public ClinicService(ClinicRepository clinicRepository,
            MedicalAppointmentServices medicalAppointmentService,
            BillService billService) {
        this.clinicRepository = clinicRepository;
        this.medicalAppointmentService = medicalAppointmentService;
        this.billService = billService;
    }

    public boolean registerPacient(Pacient pacient) {

        Optional<Pacient> existingPacient = clinicRepository.getAllPacients().stream()
                .filter(p -> p.getId().equals(pacient.getId()))
                .findFirst();

        if (existingPacient.isPresent()) {
            return false;
        }

        clinicRepository.savePacient(pacient);
        return true;
    }

    public boolean scheduleAppointment(MedicalAppointment appointment) {

        if (!medicalAppointmentService.isSlotAvailable(appointment.getDate())) {
            return false;
        }

        Bill bill = billService.createBill(appointment.getService().getPrice(), appointment.getService().getPrice());

        clinicRepository.saveAppointment(appointment);

        return true;
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
