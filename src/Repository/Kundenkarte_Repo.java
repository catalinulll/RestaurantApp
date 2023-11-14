package Repository;

import Domain.Kundenkarte;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kundenkarte_Repo extends InMemoryRepository<Kundenkarte> {
    private Map<Integer, Kundenkarte> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Kundenkarte kundenkarte) {
        data.put(nextId, kundenkarte);
        kundenkarte.setID_Kundenkarte(nextId);
        nextId++;
    }

    @Override
    public void update(Kundenkarte kundenkarte) {
        int itemId = kundenkarte.getID_Kundenkarte();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, kundenkarte);
            } else {
                throw new EntityNotFoundException("Kundenkarte with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Kundenkarte must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Kundenkarte kundenkarte) {
        int itemId = kundenkarte.getID_Kundenkarte();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Kundenkarte with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Kundenkarte must have a valid ID to be deleted");
        }
    }

    @Override
    public Kundenkarte getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Kundenkarte");
        }
    }

    @Override
    public List<Kundenkarte> getAll() {
        return new ArrayList<>(data.values());
    }
}