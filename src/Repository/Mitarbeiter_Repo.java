package Repository;

import Domain.Mitarbeiter;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mitarbeiter_Repo extends InMemoryRepository<Mitarbeiter> {
    private Map<Integer, Mitarbeiter> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Mitarbeiter mitarbeiter) {
        data.put(nextId, mitarbeiter);
        mitarbeiter.setID_Mitarbeiter(nextId);
        nextId++;
    }

    @Override
    public void update(Mitarbeiter mitarbeiter) {
        int itemId = mitarbeiter.getID_Mitarbeiter();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, mitarbeiter);
            } else {
                throw new EntityNotFoundException("Mitarbeiter with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Mitarbeiter must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Mitarbeiter mitarbeiter) {
        int itemId = mitarbeiter.getID_Mitarbeiter();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Mitarbeiter with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Mitarbeiter must have a valid ID to be deleted");
        }
    }

    @Override
    public Mitarbeiter getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Mitarbeiter");
        }
    }

    @Override
    public List<Mitarbeiter> getAll() {
        return new ArrayList<>(data.values());
    }
}
