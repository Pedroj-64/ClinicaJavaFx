
package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.*;
import co.edu.uniquindio.poo.clinicajavafx.repositories.MedicalAppointmentRepository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class MedicalAppointmentServices {

    private final MedicalAppointmentRepository appointmentRepository;
    private final BillService billService;

    public MedicalAppointmentServices(MedicalAppointmentRepository appointmentRepository, BillService billService) {
        this.appointmentRepository = appointmentRepository;
        this.billService = billService;
    }

    // 🏥 Verificar disponibilidad de horario
    public boolean isSlotAvailable(LocalDate date) {
        return appointmentRepository.getAll().stream()
                .noneMatch(appointment -> appointment.getDate().equals(date)); // Validar si ya existe cita en el mismo
                                                                               // día
    }

    // 🏥 Agendar cita médica
    public boolean scheduleAppointment(MedicalAppointment appointment) {
        // Verificar disponibilidad del horario
        if (!isSlotAvailable(appointment.getDate())) {
            return false; // Si el horario ya está ocupado, no se puede agendar
        }

        // Generar factura para la cita
        Bill bill = billService.createBill(appointment.getService().getPrice(), appointment.getService().getPrice());

        // Crear cita médica y asociar factura
        appointmentRepository.save(appointment);

        // Retornar true si la cita fue agendada con éxito
        return true;
    }

    // 🗑️ Cancelar cita médica
    public void cancelAppointment(MedicalAppointment appointment) {
        appointmentRepository.delete(appointment); // Eliminar la cita del repositorio
    }

    // 🏥 Obtener todas las citas médicas
    public LinkedList<MedicalAppointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    // 🔍 Buscar cita médica por ID
    public Optional<MedicalAppointment> getAppointmentById(UUID id) {
        return appointmentRepository.getAll().stream()
                .filter(appointment -> appointment.getId().equals(id))
                .findFirst();
    }
}
