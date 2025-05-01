package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;
import co.edu.uniquindio.poo.clinicajavafx.repositories.PacientRepository;

import java.util.LinkedList;

public class PacientServices {

    private final PacientRepository pacientRepository;

    public PacientServices(PacientRepository pacientRepository){
        this.pacientRepository=pacientRepository;
    }

    public void createPacient(Pacient pacient){
        pacientRepository.save(pacient);
    }

    public void deletePacient(String id){
        pacientRepository.delete(id);
    }

    public void updatePacient(Pacient pacient){
        pacientRepository.save(pacient);
    }

}
