package Repository;

import Domain.Lebensmittel;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lebensmittel_Repo extends InMemoryRepository<Lebensmittel> {
    private Map<Integer, Lebensmittel> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Lebensmittel lebensmittel) {
        data.put(nextId, lebensmittel);
        lebensmittel.setID_Lebensmittel(nextId);
        nextId++;
    }

    @Override
    public void update(Lebensmittel lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, lebensmittel);
            } else {
                throw new EntityNotFoundException("Lebensmittel with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Lebensmittel must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Lebensmittel lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Lebensmittel with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Lebensmittel must have a valid ID to be deleted");
        }
    }

    @Override
    public Lebensmittel getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Lebensmittel");
        }
    }

    @Override
    public List<Lebensmittel> getAll() {
        return new ArrayList<>(data.values());
    }
}
