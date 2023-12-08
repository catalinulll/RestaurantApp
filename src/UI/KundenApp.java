package UI;

import DAO.Kunden_DAO;
import Domain.Kunden;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class KundenApp {
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
            Kunden_DAO kundenDAO = new Kunden_DAO(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Adauga client");
                System.out.println("2. Modifica client");
                System.out.println("3. Sterge client");
                System.out.println("4. Afiseaza clientul cu un anumit ID");
                System.out.println("5. Afiseaza toti clientii");
                System.out.println("0. Iesire");

                System.out.print("Alege: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Kunden newKunden = new Kunden();
                        System.out.print("Introdu numele clientului: ");
                        newKunden.setName(scanner.nextLine());
                        System.out.print("Introdu adresa clientului: ");
                        newKunden.setAdresse(scanner.nextLine());
                        System.out.print("Introdu numarul de telefon al clientului: ");
                        newKunden.setTelefonnummer(scanner.nextLine());
                        kundenDAO.add(newKunden);
                        System.out.println("Clientul adaugat cu ID-ul: " + newKunden.getID_Kunde());
                        break;
                    case 2:
                        System.out.print("Introdu ID-ul clientului de modificat: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        Kunden updatedKunden = kundenDAO.getId(updateId);
                        if (updatedKunden != null) {
                            System.out.print("Introdu noul nume al clientului: ");
                            updatedKunden.setName(scanner.nextLine());
                            System.out.print("Introdu noua adresa a clientului: ");
                            updatedKunden.setAdresse(scanner.nextLine());
                            System.out.print("Introdu noul numar de telefon al clientului: ");
                            updatedKunden.setTelefonnummer(scanner.nextLine());
                            kundenDAO.update(updatedKunden);
                            System.out.println("Clientul a fost modificat cu succes");
                        } else {
                            System.out.println("Clientul nu a fost gasit");
                        }
                        break;
                    case 3:
                        System.out.print("Introdu ID-ul clientului de sters: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        Kunden deleteKunden = kundenDAO.getId(deleteId);
                        if (deleteKunden != null) {
                            kundenDAO.delete(deleteKunden);
                            System.out.println("Clientul a fost sters cu succes");
                        } else {
                            System.out.println("Nu a fost gasit clientul");
                        }
                        break;
                    case 4:
                        System.out.print("Introdu ID-ul clientului: ");
                        int getId = scanner.nextInt();
                        scanner.nextLine();
                        Kunden getKunden = kundenDAO.getId(getId);
                        if (getKunden != null) {
                            System.out.println("Detalii client: " + getKunden);
                        } else {
                            System.out.println("Nu a fost gasit clientul");
                        }
                        break;
                    case 5:
                        List<Kunden> allKunden = kundenDAO.getAll();
                        if (!allKunden.isEmpty()) {
                            System.out.println("Toti clientii:");
                            for (Kunden k : allKunden) {
                                System.out.println(k);
                            }
                        } else {
                            System.out.println("Nu au fost gasiti clienti");
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
