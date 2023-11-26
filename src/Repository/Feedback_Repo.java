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
                Feedback existingFeedback = data.get(itemId);

                // Actualizează doar câmpurile necesare
                existingFeedback.setAnzahl_der_Sterne(feedback.getAnzahl_der_Sterne());
                existingFeedback.setDatum(feedback.getDatum());
                existingFeedback.setID_Kunde(feedback.getID_Kunde());
                existingFeedback.setID_Mitarbeiter(feedback.getID_Mitarbeiter());

                data.put(itemId, existingFeedback);
            } else {
                throw new EntityNotFoundException("Feedback-ul cu ID-ul " + itemId + " nu a fost gasit");
            }
        } else {
            throw new IllegalArgumentException("Feedback-ul trebuie sa fie unul valabil pentru a putea fi actualizat");
        }
    }


    @Override
    public void delete(Feedback feedback) {
        int itemId = feedback.getID_Feedback();

        if (itemId > 0) {
            if (data.containsKey(itemId)) {
                data.remove(itemId);
            } else {
                throw new EntityNotFoundException("Feedback-ul cu ID-ul " + itemId + " nu a fost gasit si nu poate fi sters");
            }
        } else {
            throw new IllegalArgumentException("Feedback-ul trebuie sa fie valabil pentru a putea fi sters");
        }
    }

    @Override
    public Feedback getId(int id) {
        if (id > 0) {
            return data.get(id);
        } else {
            throw new IllegalArgumentException("ID-ul trebuie sa fie valabil pentru a putea fi gasit Feedback-ul");
        }
    }



    @Override
    public List<Feedback> getAll() {
        return new ArrayList<>(data.values());
    }
}