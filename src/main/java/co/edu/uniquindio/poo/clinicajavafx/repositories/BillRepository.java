
package co.edu.uniquindio.poo.clinicajavafx.repositories;

import co.edu.uniquindio.poo.clinicajavafx.model.Bill;

import java.util.*;

public class BillRepository {

    private final Map<UUID, Bill> billMap = new HashMap<>();

    public void save(Bill bill) {
        billMap.put(bill.getId(), bill);
    }

    public Optional<Bill> findById(UUID id) {
        return Optional.ofNullable(billMap.get(id));
    }

    public List<Bill> findAll() {
        return new ArrayList<>(billMap.values());
    }

    public void delete(UUID id) {
        billMap.remove(id);
    }

    public boolean exists(UUID id) {
        return billMap.containsKey(id);
    }
}
