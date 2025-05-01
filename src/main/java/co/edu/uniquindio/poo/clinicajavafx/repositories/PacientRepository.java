package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Pacient;

import java.util.LinkedList;
import java.util.Optional;

public class PacientRepository {

    public LinkedList<Pacient>pacients;

    public PacientRepository(){this.pacients=new LinkedList<>();}

    public void save(Pacient pacient){pacients.add(pacient);}

    public Optional<Pacient> getId(String id){
        return pacients.stream().filter(pacient -> pacient.getId().equals(id)).findFirst();
    }

    public void delete(String id){pacients.removeIf(pacient -> pacient.getId().equals(id));}

}
