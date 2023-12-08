package DAO;

import Domain.Gericht_im_Bestellung_im_Restaurant;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gericht_im_Bestellung_im_Restaurant_DAO {
    private Connection connection;

    public Gericht_im_Bestellung_im_Restaurant_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Gericht_im_Bestellung_im_Restaurant gericht) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Gericht_im_Bestellung_im_Restaurant (ID_Online_Bestellung) VALUES (?)");
            statement.setInt(1, gericht.getID_Online_Bestellung());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gericht_im_Bestellung_im_Restaurant gericht) {
        int itemId = gericht.getID_Online_Bestellung();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Gericht_im_Bestellung_im_Restaurant SET WHERE ID_Online_Bestellung = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Gericht_im_Bestellung_im_Restaurant gericht) {
        int itemId = gericht.getID_Online_Bestellung();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Gericht_im_Bestellung_im_Restaurant WHERE ID_Online_Bestellung = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Gericht_im_Bestellung_im_Restaurant getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Gericht_im_Bestellung_im_Restaurant WHERE ID_Online_Bestellung = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildGerichtFromResultSet(resultSet);
            } else {
                throw new IllegalArgumentException("ID trebuie sa fie valid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Gericht_im_Bestellung_im_Restaurant> getAll() {
        List<Gericht_im_Bestellung_im_Restaurant> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Gericht_im_Bestellung_im_Restaurant");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Gericht_im_Bestellung_im_Restaurant gericht = buildGerichtFromResultSet(resultSet);
                result.add(gericht);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Gericht_im_Bestellung_im_Restaurant buildGerichtFromResultSet(ResultSet resultSet) throws SQLException {
        Gericht_im_Bestellung_im_Restaurant gericht = new Gericht_im_Bestellung_im_Restaurant();
        gericht.setID_Online_Bestellung(resultSet.getInt("ID_Online_Bestellung"));
        return gericht;
    }
}
