package Repository;

import Domain.Online_Bestellungen;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Online_Bestellungen_Repo extends InMemoryRepository<Online_Bestellungen> {
    private Map<Integer, Online_Bestellungen> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Online_Bestellungen onlineBestellung) {
        data.put(nextId, onlineBestellung);
        onlineBestellung.setID_Online_Bestellung(nextId);
        nextId++;
    }

    @Override
    public void update(Online_Bestellungen onlineBestellung) {
        int itemId = onlineBestellung.getID_Online_Bestellung();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, onlineBestellung);
            } else {
                throw new EntityNotFoundException("Online Bestellung with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Online Bestellung must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Online_Bestellungen onlineBestellung) {
        int itemId = onlineBestellung.getID_Online_Bestellung();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Online Bestellung with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Online Bestellung must have a valid ID to be deleted");
        }
    }

    @Override
    public Online_Bestellungen getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Online Bestellung");
        }
    }

    @Override
    public List<Online_Bestellungen> getAll() {
        return new ArrayList<>(data.values());
    }
}