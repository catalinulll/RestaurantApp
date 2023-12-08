package DAO;

import Domain.Lebensmittel_im_Essen;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lebensmittel_im_Essen_DAO {
    private Connection connection;

    public Lebensmittel_im_Essen_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Lebensmittel_im_Essen lebensmittel) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Lebensmittel_im_Essen (ID_Lebensmittel_im_Essen, ID_Gericht, Name_Lebensmittel) " +
                            "VALUES (?, ?, ?)");
            statement.setInt(1, lebensmittel.getID_Lebensmittel_im_Essen());
            statement.setInt(2, lebensmittel.getID_Gericht());
            statement.setString(3, lebensmittel.getName_Lebensmittel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Lebensmittel_im_Essen lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel_im_Essen();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Lebensmittel_im_Essen SET ID_Gericht = ?, Name_Lebensmittel = ? " +
                            "WHERE ID_Lebensmittel_im_Essen = ?");
            statement.setInt(1, lebensmittel.getID_Gericht());
            statement.setString(2, lebensmittel.getName_Lebensmittel());
            statement.setInt(3, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Lebensmittel_im_Essen lebensmittel) {
        int itemId = lebensmittel.getID_Lebensmittel_im_Essen();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Lebensmittel_im_Essen WHERE ID_Lebensmittel_im_Essen = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Lebensmittel_im_Essen getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Lebensmittel_im_Essen WHERE ID_Lebensmittel_im_Essen = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildLebensmittelImEssenFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Lebensmittel_im_Essen cu ID " + id + " nu a fost gasit");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Lebensmittel_im_Essen> getAll() {
        List<Lebensmittel_im_Essen> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lebensmittel_im_Essen");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lebensmittel_im_Essen lebensmittel = buildLebensmittelImEssenFromResultSet(resultSet);
                result.add(lebensmittel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Lebensmittel_im_Essen buildLebensmittelImEssenFromResultSet(ResultSet resultSet) throws SQLException {
        Lebensmittel_im_Essen lebensmittel = new Lebensmittel_im_Essen();
        lebensmittel.setID_Lebensmittel_im_Essen(resultSet.getInt("ID_Lebensmittel_im_Essen"));
        lebensmittel.setID_Gericht(resultSet.getInt("ID_Gericht"));
        lebensmittel.setName_Lebensmittel(resultSet.getString("Name_Lebensmittel"));
        return lebensmittel;
    }
}
