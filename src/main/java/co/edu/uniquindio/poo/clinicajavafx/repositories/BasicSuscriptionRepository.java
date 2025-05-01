package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.BasicSuscription;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;

import java.util.ArrayList;
import java.util.List;

public class BasicSuscriptionRepository {

    private BasicSuscription basicSuscription;

    public BasicSuscriptionRepository() {
        this.basicSuscription = new BasicSuscription();
        this.basicSuscription.setServices(new ArrayList<>());
    }

    public BasicSuscription getBasicSuscription() {
        return basicSuscription;
    }

    public void addService(Service service) {
        if (!basicSuscription.getServices().contains(service)) {
            basicSuscription.getServices().add(service);
        }
    }

    public void removeService(Service service) {
        basicSuscription.getServices().remove(service);
    }

    public List<Service> getAllServices() {
        return basicSuscription.getServices();
    }

    public boolean isServiceCovered(Service service) {
        return basicSuscription.getServices().contains(service);
    }
}
