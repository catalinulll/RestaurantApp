package DAO;

import Domain.Gericht;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gericht_DAO {
    private Connection connection;

    public Gericht_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Gericht gericht) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Gericht (ID_Gericht) VALUES (?)");
            statement.setInt(1, gericht.getID_Gericht());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Gericht gericht) {
        int itemId = gericht.getID_Gericht();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Gericht SET WHERE ID_Gericht = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Gericht gericht) {
        int itemId = gericht.getID_Gericht();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Gericht WHERE ID_Gericht = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Gericht getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Gericht WHERE ID_Gericht = ?");
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

    public List<Gericht> getAll() {
        List<Gericht> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Gericht");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Gericht gericht = buildGerichtFromResultSet(resultSet);
                result.add(gericht);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Gericht buildGerichtFromResultSet(ResultSet resultSet) throws SQLException {
        Gericht gericht = new Gericht();
        gericht.setID_Gericht(resultSet.getInt("ID_Gericht"));
        return gericht;
    }
}
