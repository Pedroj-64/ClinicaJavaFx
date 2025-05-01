package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class ServiceRepository {

    private final LinkedList<Service> services;

    public ServiceRepository(){this.services=new LinkedList<>();}

    public void saveService(Service service){this.services.add(service);}

    public Optional<Service> getService(UUID id){
        return services.stream().filter(service -> service.getId().equals(id)).findFirst();}

    public void delete(UUID id){services.removeIf(service -> service.getId().equals(id));}

    
}
