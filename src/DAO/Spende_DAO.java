package DAO;

import Domain.Spende;
import Exceptions.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Spende_DAO {
    private Connection connection;

    public Spende_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Spende spende) {
        try {
            String query = "INSERT INTO Spende (ID_Spende, Adresse, ID_Gericht, Portionenanzahl) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, spende.getID_Spende());
            statement.setString(2, spende.getAdresse());
            statement.setInt(3, spende.getID_Gericht());
            statement.setInt(4, spende.getPortionenanzahl());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Spende spende) {
        int itemId = spende.getID_Spende();
        try {
            String query = "UPDATE Spende SET Adresse = ?, ID_Gericht = ?, Portionenanzahl = ? WHERE ID_Spende = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, spende.getAdresse());
            statement.setInt(2, spende.getID_Gericht());
            statement.setInt(3, spende.getPortionenanzahl());
            statement.setInt(4, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Spende spende) {
        int itemId = spende.getID_Spende();
        try {
            String query = "DELETE FROM Spende WHERE ID_Spende = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Spende getId(int id) {
        try {
            String query = "SELECT * FROM Spende WHERE ID_Spende = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildSpendeFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Spende cu ID " + id + " nu a fost gasit");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Spende> getAll() {
        List<Spende> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Spende";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Spende spende = buildSpendeFromResultSet(resultSet);
                result.add(spende);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Spende buildSpendeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("ID_Spende");
        String adresse = resultSet.getString("Adresse");
        int idGericht = resultSet.getInt("ID_Gericht");
        int portionenanzahl = resultSet.getInt("Portionenanzahl");

        Spende spende = new Spende();
        spende.setID_Spende(id);
        spende.setAdresse(adresse);
        spende.setID_Gericht(idGericht);
        spende.setPortionenanzahl(portionenanzahl);

        return spende;
    }
}
