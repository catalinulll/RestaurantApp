package DAO;

import Domain.Kundenkarte;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kundenkarte_DAO {
    private Connection connection;

    public Kundenkarte_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Kundenkarte kundenkarte) {
        try {
            String query = "INSERT INTO Kundenkarte (ID_Kundenkarte) VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, kundenkarte.getID_Kundenkarte());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Kundenkarte kundenkarte) {
        int itemId = kundenkarte.getID_Kundenkarte();
        try {
            StringBuilder setClause = new StringBuilder();

            for (java.lang.reflect.Field field : kundenkarte.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                setClause.append(field.getName()).append("=?,");
            }

            setClause.deleteCharAt(setClause.length() - 1);

            String query = String.format("UPDATE Kundenkarte SET %s WHERE ID_Kundenkarte = ?", setClause.toString());

            PreparedStatement statement = connection.prepareStatement(query);
            int parameterIndex = 1;

            for (java.lang.reflect.Field field : kundenkarte.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                statement.setObject(parameterIndex++, field.get(kundenkarte));
            }

            statement.setInt(parameterIndex, itemId);

            statement.executeUpdate();

        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void delete(Kundenkarte kundenkarte) {
        int itemId = kundenkarte.getID_Kundenkarte();
        try {
            String query = "DELETE FROM Kundenkarte WHERE ID_Kundenkarte = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Kundenkarte getId(int id) {
        try {
            String query = "SELECT * FROM Kundenkarte WHERE ID_Kundenkarte = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildKundenkarteFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Kundenkarte cu ID " + id + " nu a fost gasita");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Kundenkarte> getAll() {
        List<Kundenkarte> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Kundenkarte";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Kundenkarte kundenkarte = buildKundenkarteFromResultSet(resultSet);
                result.add(kundenkarte);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Kundenkarte buildKundenkarteFromResultSet(ResultSet resultSet) throws SQLException {
        Kundenkarte kundenkarte = new Kundenkarte();
        kundenkarte.setID_Kundenkarte(resultSet.getInt("ID_Kundenkarte"));
        return kundenkarte;
    }
}
