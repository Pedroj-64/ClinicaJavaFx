package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.BasicSuscription;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;
import co.edu.uniquindio.poo.clinicajavafx.repositories.BasicSuscriptionRepository;

import java.util.List;

public class BasicSuscriptionService {

    private final BasicSuscriptionRepository basicRepository;

    public BasicSuscriptionService(BasicSuscriptionRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public void agregarServicio(Service service) {
        basicRepository.addService(service);
    }

    public void eliminarServicio(Service service) {
        basicRepository.removeService(service);
    }

    public List<Service> obtenerServiciosCubiertos() {
        return basicRepository.getAllServices();
    }

    public boolean estaCubierto(Service service) {
        return basicRepository.isServiceCovered(service);
    }

    public BasicSuscription obtenerSuscripcion() {
        return basicRepository.getBasicSuscription();
    }
}
