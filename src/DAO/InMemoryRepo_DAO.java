package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class InMemoryRepo_DAO<T> implements Repo_DAO<T> {
    private Connection connection;

    public InMemoryRepo_DAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(T item) {
    }

    @Override
    public void update(T item) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();
        return resultList;
    }

    @Override
    public void add(Connection connection, T item) throws SQLException {

    }

    @Override
    public void update(Connection connection, T item) throws SQLException {

    }

    @Override
    public void delete(Connection connection, int id) throws SQLException {

    }

    @Override
    public T getById(Connection connection, int id) throws SQLException {
        return null;
    }

    @Override
    public List<T> getAll(Connection connection) throws SQLException {
        return null;
    }
}
