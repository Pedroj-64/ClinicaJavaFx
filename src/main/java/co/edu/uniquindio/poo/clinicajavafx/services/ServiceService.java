package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Service;
import co.edu.uniquindio.poo.clinicajavafx.repositories.ServiceRepository;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void createService(Service service) {
        serviceRepository.save(service);
    }

    public LinkedList<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(UUID id) {
        return serviceRepository.findById(id);
    }

    public void deleteService(UUID id) {
        serviceRepository.delete(id);
    }
}
