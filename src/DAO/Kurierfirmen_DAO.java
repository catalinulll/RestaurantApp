package DAO;

import Domain.Kurierfirmen;
import Exceptions.EntityNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kurierfirmen_DAO {
    private Connection connection;

    public Kurierfirmen_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Kurierfirmen kurierfirmen) {
        try {
            String query = "INSERT INTO Kurierfirmen (ID_Kurierfirma, Kuriername) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, kurierfirmen.getID_Kurierfirma());
            statement.setString(2, kurierfirmen.getKuriername());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Kurierfirmen kurierfirmen) {
        int itemId = kurierfirmen.getID_Kurierfirma();
        try {
            String query = "UPDATE Kurierfirmen SET Kuriername = ? WHERE ID_Kurierfirma = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, kurierfirmen.getKuriername());
            statement.setInt(2, itemId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Kurierfirmen kurierfirmen) {
        int itemId = kurierfirmen.getID_Kurierfirma();
        try {
            String query = "DELETE FROM Kurierfirmen WHERE ID_Kurierfirma = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Kurierfirmen getId(int id) {
        try {
            String query = "SELECT * FROM Kurierfirmen WHERE ID_Kurierfirma = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildKurierfirmenFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Kurierfirma cu ID " + id + " nu a fost gasita");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Kurierfirmen> getAll() {
        List<Kurierfirmen> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Kurierfirmen";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Kurierfirmen kurierfirmen = buildKurierfirmenFromResultSet(resultSet);
                result.add(kurierfirmen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Kurierfirmen buildKurierfirmenFromResultSet(ResultSet resultSet) throws SQLException {
        Kurierfirmen kurierfirmen = new Kurierfirmen();
        kurierfirmen.setID_Kurierfirma(resultSet.getInt("ID_Kurierfirma"));
        kurierfirmen.setKuriername(resultSet.getString("Kuriername"));
        return kurierfirmen;
    }
}
