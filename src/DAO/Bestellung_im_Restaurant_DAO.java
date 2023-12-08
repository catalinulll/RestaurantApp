package DAO;

import Domain.Bestellung_im_Restaurant;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bestellung_im_Restaurant_DAO {
    private Connection connection;

    public Bestellung_im_Restaurant_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Bestellung_im_Restaurant bestellung) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Bestellungen (ID_Bestellung_im_Restaurant) VALUES (?)");

            statement.setInt(1, bestellung.getID_Bestellung_im_Restaurant());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Bestellung_im_Restaurant bestellung) {
        int itemId = bestellung.getID_Bestellung_im_Restaurant();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Bestellungen SET WHERE ID_Bestellung_im_Restaurant = ?");

            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Bestellung_im_Restaurant bestellung) {
        int itemId = bestellung.getID_Bestellung_im_Restaurant();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Bestellungen WHERE ID_Bestellung_im_Restaurant = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bestellung_im_Restaurant getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Bestellungen WHERE ID_Bestellung_im_Restaurant = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildBestellungFromResultSet(resultSet);
            } else {
                throw new IllegalArgumentException("ID trebuie sa fie valid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Bestellung_im_Restaurant> getAll() {
        List<Bestellung_im_Restaurant> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Bestellungen");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Bestellung_im_Restaurant bestellung = buildBestellungFromResultSet(resultSet);
                result.add(bestellung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private Bestellung_im_Restaurant buildBestellungFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("ID_Bestellung_im_Restaurant");
        Date data = resultSet.getDate("data");
        float total = resultSet.getFloat("total");

        Bestellung_im_Restaurant bestellung = new Bestellung_im_Restaurant(id, data, total);

        return bestellung;
    }

}

