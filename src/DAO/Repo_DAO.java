package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repo_DAO<T> {
    void add(T item);

    void update(T item);

    void delete(int id);

    T getById(int id);

    List<T> getAll();

    void add(Connection connection, T item) throws SQLException;
    void update(Connection connection, T item) throws SQLException;
    void delete(Connection connection, int id) throws SQLException;
    T getById(Connection connection, int id) throws SQLException;
    List<T> getAll(Connection connection) throws SQLException;
}
