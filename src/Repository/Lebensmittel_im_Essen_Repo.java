package Repository;

import Domain.Lebensmittel_im_Essen;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lebensmittel_im_Essen_Repo extends InMemoryRepository<Lebensmittel_im_Essen> {
    private Map<Integer, Lebensmittel_im_Essen> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Lebensmittel_im_Essen lebensmittel) {
        data.put(nextId, lebensmittel);
        lebensmittel.setID_Lebensmittel_im_Essen(nextId);
        nextId++;
    }

    @Override
    public void update(Lebensmittel_im_Essen lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel_im_Essen();

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
    public void delete(Lebensmittel_im_Essen lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel_im_Essen();

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
    public Lebensmittel_im_Essen getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Lebensmittel");
        }
    }

    @Override
    public List<Lebensmittel_im_Essen> getAll() {
        return new ArrayList<>(data.values());
    }
}