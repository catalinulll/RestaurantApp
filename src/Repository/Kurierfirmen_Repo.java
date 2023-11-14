package Repository;

import Domain.Kurierfirmen;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kurierfirmen_Repo extends InMemoryRepository<Kurierfirmen> {
    private Map<Integer, Kurierfirmen> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void add(Kurierfirmen kurierfirmen) {
        data.put(nextId, kurierfirmen);
        kurierfirmen.setID_Kurierfirma(nextId);
        nextId++;
    }

    @Override
    public void update(Kurierfirmen kurierfirmen) {
        int itemId = kurierfirmen.getID_Kurierfirma();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                Kurierfirmen existingKurierfirmen = data.get(itemId);

                existingKurierfirmen.setKuriername(kurierfirmen.getKuriername());

                data.put(itemId, kurierfirmen);
            } else {
                throw new EntityNotFoundException("Kurierfirma with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Kurierfirma must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Kurierfirmen kurierfirmen) {
        int itemId = kurierfirmen.getID_Kurierfirma();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Kurierfirma with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Kurierfirma must have a valid ID to be deleted");
        }
    }

    @Override
    public Kurierfirmen getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the Kurierfirma");
        }
    }

    @Override
    public List<Kurierfirmen> getAll() {
        return new ArrayList<>(data.values());
    }
}