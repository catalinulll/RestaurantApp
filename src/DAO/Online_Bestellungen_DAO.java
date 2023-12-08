package DAO;

import Domain.Online_Bestellungen;
import Exceptions.EntityNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Online_Bestellungen_DAO {
    private Connection connection;

    public Online_Bestellungen_DAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Online_Bestellungen onlineBestellung) {
        try {
            String query = "INSERT INTO Online_Bestellungen (ID_Online_Bestellung, Adresse, Preis, ID_Kunde, ID_Kurierfirma) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, onlineBestellung.getID_Online_Bestellung());
            statement.setString(2, onlineBestellung.getAdresse());
            statement.setFloat(3, onlineBestellung.getPreis());
            statement.setInt(4, onlineBestellung.getID_Kunde());
            statement.setInt(5, onlineBestellung.getID_Kurierfirma());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Online_Bestellungen onlineBestellung) {
        int itemId = onlineBestellung.getID_Online_Bestellung();
        try {
            String query = "UPDATE Online_Bestellungen SET Adresse = ?, Preis = ?, ID_Kunde = ?, ID_Kurierfirma = ? WHERE ID_Online_Bestellung = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, onlineBestellung.getAdresse());
            statement.setFloat(2, onlineBestellung.getPreis());
            statement.setInt(3, onlineBestellung.getID_Kunde());
            statement.setInt(4, onlineBestellung.getID_Kurierfirma());
            statement.setInt(5, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Online_Bestellungen onlineBestellung) {
        int itemId = onlineBestellung.getID_Online_Bestellung();
        try {
            String query = "DELETE FROM Online_Bestellungen WHERE ID_Online_Bestellung = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Online_Bestellungen getId(int id) {
        try {
            String query = "SELECT * FROM Online_Bestellungen WHERE ID_Online_Bestellung = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return buildOnlineBestellungenFromResultSet(resultSet);
            } else {
                throw new EntityNotFoundException("Online_Bestellungen cu ID " + id + " nu a fost gasit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Online_Bestellungen> getAll() {
        List<Online_Bestellungen> result = new ArrayList<>();
        try {
            String query = "SELECT * FROM Online_Bestellungen";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Online_Bestellungen onlineBestellung = buildOnlineBestellungenFromResultSet(resultSet);
                result.add(onlineBestellung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Online_Bestellungen buildOnlineBestellungenFromResultSet(ResultSet resultSet) throws SQLException {
        Online_Bestellungen onlineBestellung = new Online_Bestellungen();
        onlineBestellung.setID_Online_Bestellung(resultSet.getInt("ID_Online_Bestellung"));
        onlineBestellung.setAdresse(resultSet.getString("Adresse"));
        onlineBestellung.setPreis(resultSet.getFloat("Preis"));
        onlineBestellung.setID_Kunde(resultSet.getInt("ID_Kunde"));
        onlineBestellung.setID_Kurierfirma(resultSet.getInt("ID_Kurierfirma"));
        return onlineBestellung;
    }
}
