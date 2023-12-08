package DAO;

import Domain.Tische;
import Exceptions.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tische_DAO {
    private Connection connection;

    public Tische_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Tische tische) {
        try {
            String query = "INSERT INTO Tische (ID_Tisch, Anzahl_der_Personen) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, tische.getID_Tisch());
            statement.setInt(2, tische.getAnzahl_der_Personen());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                tische.setID_Tisch(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Tische tische) {
        int itemId = tische.getID_Tisch();
        try {
            String query = "UPDATE Tische SET Anzahl_der_Personen = ? WHERE ID_Tisch = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, tische.getAnzahl_der_Personen());
            statement.setInt(2, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Tische tische) {
        int itemId = tische.getID_Tisch();
        try {
            String query = "DELETE FROM Tische WHERE ID_Tisch = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tische getId(int id) {
        try {
            String query = "SELECT * FROM Tische WHERE ID_Tisch = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildTischeFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Tische cu ID " + id + " nu a fost gasita");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Tische> getAll() {
        List<Tische> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Tische";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Tische tische = buildTischeFromResultSet(resultSet);
                result.add(tische);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Tische buildTischeFromResultSet(ResultSet resultSet) throws SQLException {
        Tische tische = new Tische(resultSet.getInt("Anzahl_der_Personen"));
        tische.setID_Tisch(resultSet.getInt("ID_Tisch"));
        return tische;
    }
}
