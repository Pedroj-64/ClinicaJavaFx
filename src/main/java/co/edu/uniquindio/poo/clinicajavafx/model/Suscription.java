package co.edu.uniquindio.poo.clinicajavafx.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Suscription {

    protected String tipo;
    protected List<Service> services;

}
    


