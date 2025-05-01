package co.edu.uniquindio.poo.clinicajavafx.model;


import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
public class Pacient {

    private String phoneNumber;
    private String name;
    private String email;
    private String id;
    private Suscription suscription;

    public Pacient(String phoneNumber, String name, String email, String id, Suscription suscription) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.id = id;
        this.suscription = suscription;
    }

}
