package Repository;

import Domain.Spende;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spende_Repo extends InMemoryRepository<Spende> {
    private Map<Integer, Spende> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Spende spende) {
        data.put(nextId, spende);
        spende.setID_Spende(nextId);
        nextId++;
    }

    @Override
    public void update(Spende spende) {
        int itemId = spende.getID_Spende();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, spende);
            } else {
                throw new EntityNotFoundException("Spende with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Spende must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Spende spende) {
        int itemId = spende.getID_Spende();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Spende with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Spende must have a valid ID to be deleted");
        }
    }

    @Override
    public Spende getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Spende");
        }
    }

    @Override
    public List<Spende> getAll() {
        return new ArrayList<>(data.values());
    }
}