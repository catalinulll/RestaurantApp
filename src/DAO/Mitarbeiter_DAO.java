package DAO;

import Domain.Mitarbeiter;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mitarbeiter_DAO {
    private Connection connection;

    public Mitarbeiter_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Mitarbeiter mitarbeiter) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Mitarbeiter (ID_Mitarbeiter, Name, Adresse, Einstellungdatum, Telefonnummer, Beruf) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, mitarbeiter.getID_Mitarbeiter());
            statement.setString(2, mitarbeiter.getName());
            statement.setString(3, mitarbeiter.getAdresse());
            statement.setDate(4, new java.sql.Date(mitarbeiter.getEinstellungdatum().getTime()));
            statement.setString(5, mitarbeiter.getTelefonnummer());
            statement.setString(6, mitarbeiter.getBeruf());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Mitarbeiter mitarbeiter) {
        int itemId = mitarbeiter.getID_Mitarbeiter();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Mitarbeiter SET Name = ?, Adresse = ?, Einstellungdatum = ?, Telefonnummer = ?, Beruf = ? " +
                            "WHERE ID_Mitarbeiter = ?");
            statement.setString(1, mitarbeiter.getName());
            statement.setString(2, mitarbeiter.getAdresse());
            statement.setDate(3, new java.sql.Date(mitarbeiter.getEinstellungdatum().getTime()));
            statement.setString(4, mitarbeiter.getTelefonnummer());
            statement.setString(5, mitarbeiter.getBeruf());
            statement.setInt(6, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Mitarbeiter mitarbeiter) {
        int itemId = mitarbeiter.getID_Mitarbeiter();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Mitarbeiter WHERE ID_Mitarbeiter = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Mitarbeiter getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Mitarbeiter WHERE ID_Mitarbeiter = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildMitarbeiterFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Mitarbeiter cu ID " + id + " nu a fost gasit");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Mitarbeiter> getAll() {
        List<Mitarbeiter> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Mitarbeiter");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Mitarbeiter mitarbeiter = buildMitarbeiterFromResultSet(resultSet);
                result.add(mitarbeiter);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Mitarbeiter buildMitarbeiterFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("ID_Mitarbeiter");
        String name = resultSet.getString("Name");
        String adresse = resultSet.getString("Adresse");
        Date einstellungdatum = resultSet.getDate("Einstellungdatum");
        String telefonnummer = resultSet.getString("Telefonnummer");
        String beruf = resultSet.getString("Beruf");

        return new Mitarbeiter(id, name, adresse, einstellungdatum, telefonnummer, beruf);
    }

}
