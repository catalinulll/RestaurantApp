package Repository;

import Domain.Bestellung_im_Restaurant;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bestellung_im_Restaurant_Repo extends InMemoryRepository<Bestellung_im_Restaurant> {
    private Map<Integer, Bestellung_im_Restaurant> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Bestellung_im_Restaurant bestellung) {
        data.put(nextId, bestellung);
        bestellung.setID_Bestellung_im_Restaurant(nextId);
        nextId++;
    }

    @Override
    public void update(Bestellung_im_Restaurant bestellung) {
        int itemId = bestellung.getID_Bestellung_im_Restaurant();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, bestellung);
            } else {
                throw new EntityNotFoundException("Bestellung mit ID-ul " + itemId + " wurde nicht gefunden");
            }
        } else {
            throw new IllegalArgumentException("Bestellung muss eine gültige ID haben, um aktualisiert zu werden");
        }
    }

    @Override
    public void delete(Bestellung_im_Restaurant bestellung) {
        int itemId = bestellung.getID_Bestellung_im_Restaurant();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Bestellung mit ID-ul " + itemId + " wurde nicht gefunden und kann nicht gelöscht werden");
            }
        } else {
            throw new IllegalArgumentException("Bestellung muss eine gültige ID haben, um gelöscht zu werden");
        }
    }

    @Override
    public Bestellung_im_Restaurant getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID muss eine gültige Nummer sein, um Bestellung zu erhalten");
        }
    }

    @Override
    public List<Bestellung_im_Restaurant> getAll() {
        return new ArrayList<>(data.values());
    }
}