package co.edu.uniquindio.poo.clinicajavafx.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

@Getter    
public class MedicalAppointment {
   
    private Pacient pacient;
    private UUID id;
    private LocalDate date;
    private Service service;
    private Bill bill;


    public MedicalAppointment(Pacient pacient, LocalDate date, Service service) {
        this.pacient = pacient;
        this.id = UUID.randomUUID();
        this.date = date;
        this.service = service;
        this.bill = new Bill(date, service.getPrice(), service.getPrice() * 0.8);
    }
}
