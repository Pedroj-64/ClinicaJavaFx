package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;
import co.edu.uniquindio.poo.clinicajavafx.repositories.PacientRepository;

import java.util.List;
import java.util.Optional;

public class PacientServices {

    private final PacientRepository pacientRepository;

    public PacientServices(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public boolean registerPacient(Pacient pacient) {
        if (pacientRepository.findById(pacient.getId()).isPresent()) {
            return false;
        }
        pacientRepository.save(pacient);
        return true;
    }

    public Optional<Pacient> getPacientById(String id) {
        return pacientRepository.findById(id);
    }

    public List<Pacient> getAllPacients() {
        return pacientRepository.findAll();
    }

    public boolean deletePacient(String id) {
        Optional<Pacient> existing = pacientRepository.findById(id);
        if (existing.isPresent()) {
            pacientRepository.delete(id);
            return true;
        }
        return false;
    }
}
