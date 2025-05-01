package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;

import java.util.LinkedList;
import java.util.Optional;

public class PacientRepository {

    public LinkedList<Pacient> pacients;

    public PacientRepository() {
        this.pacients = new LinkedList<>();
    }

    public void save(Pacient pacient) {
        if (findById(pacient.getId()).isPresent()) {
            throw new IllegalArgumentException("Paciente con ID " + pacient.getId() + " ya existe.");
        } else {
            pacients.add(pacient);
        }
    }

    public Optional<Pacient> findById(String id) {
        return pacients.stream().filter(pacient -> pacient.getId().equals(id)).findFirst();
    }

    public LinkedList<Pacient> findAll() {
        return new LinkedList<>(pacients);
    }

    public void delete(String id) {
        pacients.removeIf(pacient -> pacient.getId().equals(id));
    }

}
