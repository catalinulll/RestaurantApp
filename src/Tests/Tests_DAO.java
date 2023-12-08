package Tests;

import DAO.Kunden_DAO;
import DAO.Tische_DAO;
import Domain.Kunden;
import Domain.Tische;
import Exceptions.EntityNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Tests_DAO {

    public static void main(String[] args) throws SQLException {
        testKundenDAO();
        testTischeDAO();
    }

    private static void testKundenDAO() throws SQLException {
        Connection connection = getConnection();
        Kunden_DAO kundenDAO = new Kunden_DAO(connection);

        Kunden kundenToAdd = new Kunden();
        kundenToAdd.setName("Ion");
        kundenToAdd.setAdresse("Adresa1");
        kundenToAdd.setTelefonnummer("0782918231");

        kundenDAO.add(kundenToAdd);

        Kunden retrievedKunden = kundenDAO.getId(kundenToAdd.getID_Kunde());

        assert retrievedKunden != null : "Testul pentru Kunden_DAO - Add si GetByID: FAILED";

        kundenToAdd.setName("Ion Vasile");
        kundenToAdd.setAdresse("Adresa2");
        kundenToAdd.setTelefonnummer("0715273819");

        kundenDAO.update(kundenToAdd);
        Kunden updatedKunden = kundenDAO.getId(kundenToAdd.getID_Kunde());

        assert updatedKunden != null && "Ion Vasile".equals(updatedKunden.getName())
                && "Adresa2".equals(updatedKunden.getAdresse())
                && "0715273819".equals(updatedKunden.getTelefonnummer()) : "Testul pentru Kunden_DAO - Update: FAILED";

        List<Kunden> allKunden = kundenDAO.getAll();

        assert allKunden != null && !allKunden.isEmpty() : "Testul pentru Kunden_DAO - Get All: FAILED";

        System.out.println("Toate testele pentru Kunden_DAO merg bine");
    }

    private static void testTischeDAO() throws SQLException {
        Connection connection = getConnection();
        Tische_DAO tischeDAO = new Tische_DAO(connection);

        Tische tischeToAdd = new Tische(4);
        tischeDAO.add(tischeToAdd);

        Tische retrievedTische = tischeDAO.getId(tischeToAdd.getID_Tisch());
        assert retrievedTische != null : "Testul pentru Tische_DAO - Add si GetByID: FAILED";

        tischeToAdd.setAnzahl_der_Personen(6);
        tischeDAO.update(tischeToAdd);
        Tische updatedTische = tischeDAO.getId(tischeToAdd.getID_Tisch());
        assert updatedTische != null && updatedTische.getAnzahl_der_Personen() == 6 : "Testul pentru Tische_DAO - Update: FAILED";

        tischeDAO.delete(tischeToAdd);
        Tische deletedTische = null;
        try {
            deletedTische = tischeDAO.getId(tischeToAdd.getID_Tisch());
            assert false : "Testul pentru Tische_DAO - Delete: FAILED";
        } catch (EntityNotFoundException e) {
        }

        List<Tische> allTische = tischeDAO.getAll();
        assert allTische != null && !allTische.isEmpty() : "Testul pentru Tische_DAO - Get All: FAILED";

        System.out.println("Toate testele pentru Tische_DAO merg bine");
    }

    private static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/restaurantapp";
        String username = "postgres";
        String password = "parola";

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
