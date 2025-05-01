package co.edu.uniquindio.poo.clinicajavafx.model.factory;

import co.edu.uniquindio.poo.clinicajavafx.model.BasicSuscription;
import co.edu.uniquindio.poo.clinicajavafx.model.PremiumSuscription;
import co.edu.uniquindio.poo.clinicajavafx.model.Suscription;

public class SuscriptionFactory {

    public static Suscription createSuscription(String tipo) {
        if (tipo.equalsIgnoreCase("Básica")) {
            return new BasicSuscription();
        } else if (tipo.equalsIgnoreCase("Premium")) {
            return new PremiumSuscription();
        } else {
            throw new IllegalArgumentException("Tipo de suscripción no válido: " + tipo);
        }
    }

}
