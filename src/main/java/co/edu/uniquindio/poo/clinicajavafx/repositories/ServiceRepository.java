package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class ServiceRepository {

    private final LinkedList<Service> services;

    public ServiceRepository() {
        this.services = new LinkedList<>();
    }

    public void save(Service service) {
        services.add(service);
    }

    public Optional<Service> findById(UUID id) {
        return services.stream()
                .filter(service -> service.getId().equals(id))
                .findFirst();
    }

    public LinkedList<Service> findAll() {
        return new LinkedList<>(services);
    }

    public void delete(UUID id) {
        services.removeIf(service -> service.getId().equals(id));
    }
}
