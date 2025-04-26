package co.edu.uniquindio.poo.clinicajavafx.model;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Service {

    private double price;
    private String name;
    private UUID id;

    public Service(double price, String name) {
        this.price = price;
        this.name = name;
        this.id = UUID.randomUUID();
    }
    
}
