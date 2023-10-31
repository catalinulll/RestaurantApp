package Controller;
import Exceptions.EntityNotFoundException;
import Repository.Repository;
import java.util.List;

public class Controller<T> {
    private final Repository<T> repository;

    public Controller(Repository<T> repository) {
        this.repository = repository;
    }

    public void create(T item) {
        repository.add(item);
    }

    public T read(int id) {
        T item = repository.getId(id);
        if (item == null) {
            throw new EntityNotFoundException("Entitatea cu ID-ul " + id + " nu a fost gasita");
        }
        return item;
    }

    public void update(T item) {
        repository.update(item);
    }

    public void delete(int id) {
        T item = repository.getId(id);
        if (item == null) {
            throw new EntityNotFoundException("Entitatea cu ID-ul " + id + " nu a fost gasita si nu poate fi stearsa");
        }
        repository.delete(item);
    }

    public List<T> getAll() {
        return repository.getAll();
    }
}