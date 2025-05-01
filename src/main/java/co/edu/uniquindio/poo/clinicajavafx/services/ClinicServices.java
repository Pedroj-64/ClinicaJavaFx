package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Clinic;
import co.edu.uniquindio.poo.clinicajavafx.repositories.ClinicRepository;

public class ClinicServices {

    private final ClinicRepository clinicRepository;

    public ClinicServices(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    //no se si esto sea asi pero por ahora
    public void createClinic(Clinic clinic) {
        clinicRepository.saveClinic(clinic);
    }

    public void deleteClinic(Clinic clinic){
        clinicRepository.deleteClinic(clinic);
    }





    
}
