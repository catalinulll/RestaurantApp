package Controller;

import Domain.Kurierfirmen;
import Exceptions.EntityNotFoundException;
import DAO.Repo_DAO;
import java.util.List;

public class Controller<T> {
    Repo_DAO<T> repository;

    public Controller(Repo_DAO<T> repository) {
        this.repository = repository;
    }

    public void create(T item) {
        repository.add(item);
    }

    public T read(int id) {
        T item = repository.getById(id);
        if (item == null) {
            throw new EntityNotFoundException("Entitatea cu ID-ul " + id + " nu a fost gasita");
        }
        return item;
    }

    public void update(T item) {
        repository.update(item);
    }

    public void delete(int id) {
        repository.delete(id);  }

    public List<T> getAll() {
        return repository.getAll();
    }
}
