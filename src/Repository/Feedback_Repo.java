package Repository;

import Domain.Feedback;
import Exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feedback_Repo extends InMemoryRepository<Feedback> {
    private Map<Integer, Feedback> data = new HashMap<>();
    private int nextId = 1;

    public Feedback_Repo(Map<Integer, Feedback> existingData) {
        this.data = existingData;
        this.nextId = existingData.size() + 1;
    }
    @Override
    public void add(Feedback feedback) {
        feedback.setID_Feedback(nextId);
        data.put(nextId, feedback);
        nextId++;
    }


    @Override
    public void update(Feedback feedback) {
        int itemId = feedback.getID_Feedback();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.put(itemId, feedback);
            } else {
                throw new EntityNotFoundException("Feedback with ID " + itemId + " was not found");
            }
        } else {
            throw new IllegalArgumentException("Feedback must have a valid ID to be updated");
        }
    }

    @Override
    public void delete(Feedback feedback) {
        int itemId = feedback.getID_Feedback();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Feedback with ID " + itemId + " was not found and cannot be deleted");
            }
        } else {
            throw new IllegalArgumentException("Feedback must have a valid ID to be deleted");
        }
    }

    @Override
    public Feedback getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID must be a valid number to get the feedback");
        }
    }

    @Override
    public List<Feedback> getAll() {
        return new ArrayList<>(data.values());
    }
}
