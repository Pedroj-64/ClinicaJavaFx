package co.edu.uniquindio.poo.clinicajavafx.services;

import co.edu.uniquindio.poo.clinicajavafx.model.Bill;
import co.edu.uniquindio.poo.clinicajavafx.repositories.BillRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill(double subtotal, double total) {
        Bill bill = new Bill(LocalDate.now(), total, subtotal);
        billRepository.save(bill);
        return bill;
    }

    public Optional<Bill> getBillById(UUID id) {
        return billRepository.findById(id);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public boolean deleteBill(UUID id) {
        if (billRepository.exists(id)) {
            billRepository.delete(id);
            return true;
        }
        return false;
    }
}
