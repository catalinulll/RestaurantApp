package Repository;

import Domain.Kunden;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kunden_Repo extends InMemoryRepository<Kunden> {
    private Map<Integer, Kunden> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Kunden kunden) {
        data.put(nextId, kunden);
        kunden.setID_Kunde(nextId);
        nextId++;
    }

    @Override
    public void update(Kunden kunden) {
        int itemId = kunden.getID_Kunde();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, kunden);
            } else {
                throw new EntityNotFoundException("Kunden with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Kunden must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Kunden kunden) {
        int itemId = kunden.getID_Kunde();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Kunden with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Kunden must have a valid ID to be deleted");
        }
    }

    @Override
    public Kunden getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Kunden");
        }
    }

    @Override
    public List<Kunden> getAll() {
        return new ArrayList<>(data.values());
    }
}
