package Repository;

import Domain.Gericht_im_Online_Bestellung;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gericht_im_Online_Bestellung_Repo extends InMemoryRepository<Gericht_im_Online_Bestellung> {
    private Map<Integer, Gericht_im_Online_Bestellung> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Gericht_im_Online_Bestellung gericht) {
        data.put(nextId, gericht);
        gericht.setID_Gericht_im_Restaurant(nextId);
        nextId++;
    }

    @Override
    public void update(Gericht_im_Online_Bestellung gericht) {
        int itemId = gericht.getID_Gericht_im_Restaurant();

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
    public void delete(Gericht_im_Online_Bestellung gericht) {
        int itemId = gericht.getID_Gericht_im_Restaurant();

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
    public Gericht_im_Online_Bestellung getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Gericht");
        }
    }

    @Override
    public List<Gericht_im_Online_Bestellung> getAll() {
        return new ArrayList<>(data.values());
    }
}
