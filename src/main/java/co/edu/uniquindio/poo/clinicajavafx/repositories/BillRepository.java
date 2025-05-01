package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Bill;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

public class BillRepository {

    private final LinkedList<Bill> bills;

    public BillRepository() {this.bills=new LinkedList<>();}

    public void save(Bill bill){bills.add(bill);}

    public Optional<Bill> getBill(UUID billid){
        return bills.stream().filter(bill -> bill.getId().equals(billid)).findFirst();
    }

    public void delete(UUID billid){bills.removeIf(bill -> bill.getId().equals(billid));}
}
