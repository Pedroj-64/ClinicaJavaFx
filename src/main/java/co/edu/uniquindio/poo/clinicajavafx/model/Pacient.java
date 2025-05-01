package co.edu.uniquindio.poo.clinicajavafx.model;

import co.edu.uniquindio.poo.clinicajavafx.model.factory.SuscriptionFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pacient {

    private String phoneNumber;
    private String name;
    private String email;
    private String id;
    private SuscriptionFactory suscription;

    public Pacient(String phoneNumber, String name, String email, String id, SuscriptionFactory suscription) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.id = id;
        this.suscription = suscription;
    }

}
