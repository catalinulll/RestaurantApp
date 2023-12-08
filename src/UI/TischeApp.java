package UI;

import DAO.Tische_DAO;
import Domain.Tische;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TischeApp {
    public static void main(String[] args) {
        String driverClassName = "org.postgresql.Driver";

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/restaurantapp";
        String username = "postgres";
        String password = "parola";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Tische_DAO tischeDAO = new Tische_DAO(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Adauga masa");
                System.out.println("2. Modifica masa");
                System.out.println("3. Sterge masa");
                System.out.println("4. Afiseaza masa cu un anumit ID");
                System.out.println("5. Afiseaza toate mesele");
                System.out.println("0. Iesire");

                System.out.print("Alege: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Adauga numarul de persoane: ");
                        int numberOfPersons = scanner.nextInt();
                        Tische newTisch = new Tische(numberOfPersons);
                        tischeDAO.add(newTisch);
                        System.out.println("Masa adaugata cu ID-ul: " + newTisch.getID_Tisch());
                        break;
                    case 2:
                        System.out.print("Introdu ID-ul mesei de modificat: ");
                        int updateId = scanner.nextInt();
                        Tische updatedTisch = tischeDAO.getId(updateId);
                        if (updatedTisch != null) {
                            System.out.print("Introdu noul numar de persoane: ");
                            int newNumberOfPersons = scanner.nextInt();
                            updatedTisch.setAnzahl_der_Personen(newNumberOfPersons);
                            tischeDAO.update(updatedTisch);
                            System.out.println("Masa modificata cu succes");
                        } else {
                            System.out.println("Masa nu a fost gasita");
                        }
                        break;
                    case 3:
                        System.out.print("Introdu ID-ul mesei de sters: ");
                        int deleteId = scanner.nextInt();
                        Tische deleteTisch = tischeDAO.getId(deleteId);
                        if (deleteTisch != null) {
                            tischeDAO.delete(deleteTisch);
                            System.out.println("Masa stearsa cu succes");
                        } else {
                            System.out.println("Masa nu a fost gasita");
                        }
                        break;
                    case 4:
                        System.out.print("Introdu ID-ul mesei de cautat: ");
                        int getId = scanner.nextInt();
                        Tische getTisch = tischeDAO.getId(getId);
                        if (getTisch != null) {
                            System.out.println("Detalii masa: " +
                                    "ID_Tisch=" + getTisch.getID_Tisch() +
                                    ", Anzahl_der_Personen=" + getTisch.getAnzahl_der_Personen());
                        } else {
                            System.out.println("Masa nu a fost gasita");
                        }
                        break;

                    case 5:
                        List<Tische> allTische = tischeDAO.getAll();
                        if (!allTische.isEmpty()) {
                            System.out.println("Toate mesele:");
                            for (Tische t : allTische) {
                                System.out.println("ID_Tisch=" + t.getID_Tisch() +
                                        ", Anzahl_der_Personen=" + t.getAnzahl_der_Personen());
                            }
                        } else {
                            System.out.println("Nu au fost gasite mese");
                        }
                        break;

                    case 0:
                        System.out.println("Iesire...");
                        System.exit(0);
                    default:
                        System.out.println("Optiune invalida");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
