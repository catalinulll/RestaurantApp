package Repository;

import Domain.Gericht;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gericht_Repo extends InMemoryRepository<Gericht> {
    private Map<Integer, Gericht> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Gericht gericht) {
        data.put(nextId, gericht);
        gericht.setID_Gericht(nextId);
        nextId++;
    }

    @Override
    public void update(Gericht gericht) {
        int itemId = gericht.getID_Gericht();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, gericht);
            } else {
                throw new EntityNotFoundException("Gericht with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Gericht must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Gericht gericht) {
        int itemId = gericht.getID_Gericht();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Gericht with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Gericht must have a valid ID to be deleted");
        }
    }

    @Override
    public Gericht getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Gericht");
        }
    }

    @Override
    public List<Gericht> getAll() {
        return new ArrayList<>(data.values());
    }
}
