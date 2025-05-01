package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.PremiumSuscription;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;

import java.util.ArrayList;
import java.util.List;

public class PremiumSuscriptionRepository {

    private PremiumSuscription premiumSuscription;

    public PremiumSuscriptionRepository() {
        this.premiumSuscription = new PremiumSuscription();
        this.premiumSuscription.setServices(new ArrayList<>());
    }

    public PremiumSuscription getPremiumSuscription() {
        return premiumSuscription;
    }

    public void addService(Service service) {
        if (!premiumSuscription.getServices().contains(service)) {
            premiumSuscription.getServices().add(service);
        }
    }

    public void removeService(Service service) {
        premiumSuscription.getServices().remove(service);
    }

    public List<Service> getAllServices() {
        return premiumSuscription.getServices();
    }

    public boolean isServiceCovered(Service service) {
        return premiumSuscription.getServices().contains(service);
    }
}
