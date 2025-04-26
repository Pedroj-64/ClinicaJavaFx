package co.edu.uniquindio.poo.clinicajavafx.model;

import java.util.LinkedList;

import lombok.Getter;

@Getter
public class Clinic {

    private LinkedList<MedicalAppointment> medicalAppointments;
    private LinkedList<Service> services;
    private LinkedList<Pacient> pacients;

    public Clinic() {
        this.medicalAppointments = new LinkedList<>();
        this.services = new LinkedList<>();
        this.pacients = new LinkedList<>();
    }
    
}
