package co.edu.uniquindio.poo.clinicajavafx.model.factory;
import co.edu.uniquindio.poo.clinicajavafx.model.Bill;
import co.edu.uniquindio.poo.clinicajavafx.model.Service;
import java.util.LinkedList;

public interface ISuscripction {

    LinkedList<Service> getAvalibleServices();
    Bill generateBill(Service service);
    
}
