package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Service;
import co.edu.uniquindio.poo.clinicajavafx.model.PremiumSuscription;
import co.edu.uniquindio.poo.clinicajavafx.repositories.PremiumSuscriptionRepository;

import java.util.List;

public class PremiumSuscriptionService {

    private final PremiumSuscriptionRepository premiumRepository;

    public PremiumSuscriptionService(PremiumSuscriptionRepository premiumRepository) {
        this.premiumRepository = premiumRepository;
    }

    public void agregarServicio(Service service) {
        premiumRepository.addService(service);
    }

    public void eliminarServicio(Service service) {
        premiumRepository.removeService(service);
    }

    public List<Service> obtenerServiciosCubiertos() {
        return premiumRepository.getAllServices();
    }

    public boolean estaCubierto(Service service) {
        return premiumRepository.isServiceCovered(service);
    }

    public PremiumSuscription obtenerSuscripcion() {
        return premiumRepository.getPremiumSuscription();
    }
}
