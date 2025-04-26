package co.edu.uniquindio.poo.clinicajavafx.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Bill {

    private LocalDate date;
    private UUID id;
    private double total;
    private double subtotal;

    public Bill(LocalDate date, double total, double subtotal) {
        this.date = date;
        this.id = UUID.randomUUID();
        this.total = total;
        this.subtotal = subtotal;
    }
    
}
