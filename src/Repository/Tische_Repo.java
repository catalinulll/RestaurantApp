package Repository;

import Domain.Tische;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tische_Repo extends InMemoryRepository<Tische> {
    private Map<Integer, Tische> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Tische tische) {
        data.put(nextId, tische);
        tische.setID_Tisch(nextId);
        nextId++;
    }

    @Override
    public void update(Tische tische) {
        int itemId = tische.getID_Tisch();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, tische);
            } else {
                throw new EntityNotFoundException("Masa cu ID-ul " + itemId + " nu a fost gasita");
            }
        } else {
            throw new IllegalArgumentException("Masa trebuie sa aiba un ID valid pentru a fi actualizata");
        }
    }

    @Override
    public void delete(Tische tische) {
        int itemId = tische.getID_Tisch();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Masa cu ID-ul " + itemId + " nu a fost gasita si nu poate fi stearsa");
            }
        } else {
            throw new IllegalArgumentException("Masa trebuie sa aiba un ID valid pentru a fi stearsa");
        }
    }

    @Override
    public Tische getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID-ul trebuie sa fie un numar valid pentru a obtine masa");
        }
    }

    @Override
    public List<Tische> getAll() {
        return new ArrayList<>(data.values());
    }
}