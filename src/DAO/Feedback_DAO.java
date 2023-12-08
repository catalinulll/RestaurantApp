package DAO;

import Domain.Feedback;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Feedback_DAO {
    private Connection connection;

    public Feedback_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Feedback feedback) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Feedback (ID_Feedback, Anzahl_der_Sterne, Datum, ID_Kunde, ID_Mitarbeiter) " +
                            "VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, feedback.getID_Feedback());
            statement.setInt(2, feedback.getAnzahl_der_Sterne());
            statement.setDate(3, feedback.getDatum());
            statement.setInt(4, feedback.getID_Kunde());
            statement.setInt(5, feedback.getID_Mitarbeiter());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Feedback feedback) {
        int itemId = feedback.getID_Feedback();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Feedback SET Anzahl_der_Sterne = ?, Datum = ?, ID_Kunde = ?, ID_Mitarbeiter = ? " +
                            "WHERE ID_Feedback = ?");
            statement.setInt(1, feedback.getAnzahl_der_Sterne());
            statement.setDate(2, feedback.getDatum());
            statement.setInt(3, feedback.getID_Kunde());
            statement.setInt(4, feedback.getID_Mitarbeiter());
            statement.setInt(5, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Feedback feedback) {
        int itemId = feedback.getID_Feedback();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM Feedback WHERE ID_Feedback = ?");
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException | EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Feedback getId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Feedback WHERE ID_Feedback = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildFeedbackFromResultSet(resultSet);
            } else {
                throw new IllegalArgumentException("ID trebuie sa fie valid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Feedback> getAll() {
        List<Feedback> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Feedback");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Feedback feedback = buildFeedbackFromResultSet(resultSet);
                result.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Feedback buildFeedbackFromResultSet(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setID_Feedback(resultSet.getInt("ID_Feedback"));
        feedback.setAnzahl_der_Sterne(resultSet.getInt("Anzahl_der_Sterne"));
        feedback.setDatum(resultSet.getDate("Datum"));
        feedback.setID_Kunde(resultSet.getInt("ID_Kunde"));
        feedback.setID_Mitarbeiter(resultSet.getInt("ID_Mitarbeiter"));
        return feedback;
    }
}
