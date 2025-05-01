
package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.*;
import co.edu.uniquindio.poo.clinicajavafx.repositories.MedicalAppointmentRepository;
import co.edu.uniquindio.poo.clinicajavafx.utils.SendEmail;

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

    public boolean isSlotAvailable(LocalDate date) {
        return appointmentRepository.getAll().stream()
                .noneMatch(appointment -> appointment.getDate().equals(date));

    }

    public boolean scheduleAppointment(MedicalAppointment appointment) {

        if (!isSlotAvailable(appointment.getDate())) {
            return false;
        }
    
        Pacient pacient = appointment.getPacient();
        Suscription suscription = pacient.getSuscription();
        Service service = appointment.getService();
    
        double subtotal = service.getPrice();
        double total;
    
        if (suscription != null && suscription.getServices().contains(service)) {
            total = 0; 
        } else {
            total = subtotal * 0.8; 
        }
    
        Bill bill = billService.createBill(subtotal, total);
    
        appointmentRepository.save(appointment);
    
        // Enviar notificación por correo
        String receiver = pacient.getEmail();
        String subject = "Confirmación de cita médica";
        String message = String.format(
                "Hola %s,\n\nTu cita ha sido agendada con éxito.\n" +
                        "Fecha y hora: %s\n" +
                        "Servicio: %s\n" +
                        "Total pagado: $%.2f\n\nGracias por confiar en nuestra clínica.",
                pacient.getName(),
                appointment.getDate().toString(),
                service.getName(),
                bill.getTotal());
    
        SendEmail.enviarNotificacion(receiver, subject, message);
    
        return true;
    }
    

    public void cancelAppointment(MedicalAppointment appointment) {

        appointmentRepository.delete(appointment);

        String receiver = appointment.getPacient().getEmail();
        String subject = "Cancelación de cita médica";
        String message = String.format(
                "Hola %s,\n\nTu cita del %s para el servicio %s ha sido cancelada exitosamente.\n" +
                        "Si deseas reprogramarla, por favor contáctanos.\n\nGracias.",
                appointment.getPacient().getName(),
                appointment.getDate().toString(),
                appointment.getService().getName());

        SendEmail.enviarNotificacion(receiver, subject, message);
    }

    public LinkedList<MedicalAppointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    public Optional<MedicalAppointment> getAppointmentById(UUID id) {
        return appointmentRepository.getAll().stream()
                .filter(appointment -> appointment.getId().equals(id))
                .findFirst();
    }
}
