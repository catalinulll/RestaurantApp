package DAO;

import Domain.Lebensmittel;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lebensmittel_DAO {
    private Connection connection;

    public Lebensmittel_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Lebensmittel lebensmittel) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Lebensmittel (ID_Lebensmittel, Name_Lebensmittel, Quantitat) " +
                            "VALUES (?, ?, ?)");
            statement.setInt(1, lebensmittel.getID_Lebensmittel());
            statement.setString(2, lebensmittel.getName_Lebensmittel());
            statement.setInt(3, lebensmittel.getQuantitat());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Lebensmittel lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Lebensmittel SET Name_Lebensmittel = ?, Quantitat = ? " +
                            "WHERE ID_Lebensmittel = ?");
            statement.setString(1, lebensmittel.getName_Lebensmittel());
            statement.setInt(2, lebensmittel.getQuantitat());
            statement.setInt(3, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Lebensmittel lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Lebensmittel WHERE ID_Lebensmittel = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Lebensmittel getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Lebensmittel WHERE ID_Lebensmittel = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildLebensmittelFromResultSet(resultSet);
            } else {
                throw new IllegalArgumentException("ID trebuie sa fie valabil");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Lebensmittel> getAll() {
        List<Lebensmittel> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lebensmittel");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lebensmittel lebensmittel = buildLebensmittelFromResultSet(resultSet);
                result.add(lebensmittel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Lebensmittel buildLebensmittelFromResultSet(ResultSet resultSet) throws SQLException {
        Lebensmittel lebensmittel = new Lebensmittel();
        lebensmittel.setID_Lebensmittel(resultSet.getInt("ID_Lebensmittel"));
        lebensmittel.setName_Lebensmittel(resultSet.getString("Name_Lebensmittel"));
        lebensmittel.setQuantitat(resultSet.getInt("Quantitat"));
        return lebensmittel;
    }
}
