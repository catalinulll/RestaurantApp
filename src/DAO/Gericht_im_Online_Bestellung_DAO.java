package DAO;

import Domain.Gericht_im_Online_Bestellung;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gericht_im_Online_Bestellung_DAO {
    private Connection connection;

    public Gericht_im_Online_Bestellung_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Gericht_im_Online_Bestellung gericht) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Gericht_im_Online_Bestellung (ID_Gericht_im_Restaurant) VALUES (?)");
            statement.setInt(1, gericht.getID_Gericht_im_Restaurant());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gericht_im_Online_Bestellung gericht) {
        int itemId = gericht.getID_Gericht_im_Restaurant();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Gericht_im_Online_Bestellung SET WHERE ID_Gericht_im_Restaurant = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Gericht_im_Online_Bestellung gericht) {
        int itemId = gericht.getID_Gericht_im_Restaurant();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Gericht_im_Online_Bestellung WHERE ID_Gericht_im_Restaurant = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Gericht_im_Online_Bestellung getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Gericht_im_Online_Bestellung WHERE ID_Gericht_im_Restaurant = ?");
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

    public List<Gericht_im_Online_Bestellung> getAll() {
        List<Gericht_im_Online_Bestellung> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Gericht_im_Online_Bestellung");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Gericht_im_Online_Bestellung gericht = buildGerichtFromResultSet(resultSet);
                result.add(gericht);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Gericht_im_Online_Bestellung buildGerichtFromResultSet(ResultSet resultSet) throws SQLException {
        Gericht_im_Online_Bestellung gericht = new Gericht_im_Online_Bestellung();
        gericht.setID_Gericht_im_Restaurant(resultSet.getInt("ID_Gericht_im_Restaurant"));
        return gericht;
    }
}
