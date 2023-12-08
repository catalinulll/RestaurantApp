package DAO;

import Domain.Kunden;
import Exceptions.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kunden_DAO {
    private Connection connection;

    public Kunden_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Kunden kunden) {
        try {
            String query = "INSERT INTO Kunden (Name, Adresse, Telefonnummer) VALUES (?, ?, ?) RETURNING ID_Kunde";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, kunden.getName());
            statement.setString(2, kunden.getAdresse());
            statement.setString(3, kunden.getTelefonnummer());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                kunden.setID_Kunde(resultSet.getInt("ID_Kunde"));
            } else {
                throw new SQLException("Nu s-a putut crea un client");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Kunden kunden) {
        int itemId = kunden.getID_Kunde();
        try {
            StringBuilder setClause = new StringBuilder();

            for (java.lang.reflect.Field field : kunden.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                setClause.append(field.getName()).append("=?,");
            }

            setClause.deleteCharAt(setClause.length() - 1);

            String query = String.format("UPDATE Kunden SET %s WHERE ID_Kunde = ?", setClause.toString());

            PreparedStatement statement = connection.prepareStatement(query);
            int parameterIndex = 1;

            for (java.lang.reflect.Field field : kunden.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                statement.setObject(parameterIndex++, field.get(kunden));
            }

            statement.setInt(parameterIndex, itemId);

            statement.executeUpdate();

        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void delete(Kunden kunden) {
        int itemId = kunden.getID_Kunde();
        try {
            String query = "DELETE FROM Kunden WHERE ID_Kunde = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Kunden getId(int id) {
        try {
            String query = "SELECT * FROM Kunden WHERE ID_Kunde = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildKundenFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Kunde cu ID " + id + " nu a fost gasit");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Kunden> getAll() {
        List<Kunden> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Kunden";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Kunden kunden = buildKundenFromResultSet(resultSet);
                result.add(kunden);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Kunden buildKundenFromResultSet(ResultSet resultSet) throws SQLException {
        Kunden kunden = new Kunden();
        kunden.setID_Kunde(resultSet.getInt("ID_Kunde"));
        kunden.setName(resultSet.getString("Name"));
        kunden.setAdresse(resultSet.getString("Adresse"));
        kunden.setTelefonnummer(resultSet.getString("Telefonnummer"));
        return kunden;
    }

}
