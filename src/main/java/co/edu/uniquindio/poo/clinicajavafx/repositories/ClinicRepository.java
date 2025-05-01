package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Clinic;

import java.util.Optional;

public class ClinicRepository {

    private Clinic Clinic;

    public void saveClinic(Clinic clinic){this.Clinic=clinic;}

    public Optional<Clinic> getClinic(){return Optional.ofNullable(this.Clinic);}

    public void deleteClinic(Clinic clinic){this.Clinic=null;}
    
}
