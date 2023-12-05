package UI;

import Domain.Restaurant;
import Domain.Tische;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManagerConnectionStrategy implements UserInterface {
    private Restaurant restaurant;

    public ManagerConnectionStrategy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void displayMenu() {
        System.out.println("Meniu manager:");
        displayMenuFromFile("C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\meniu.txt");
    }

    private void displayMenuFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea meniului din fișier: " + e.getMessage());
        }
    }

    @Override
    public void processInput() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Adăugare masă");
            System.out.println("2. Ștergere masă");
            System.out.println("3. Modificare masă");
            System.out.println("4. Afișare feedback-uri");
            System.out.println("0. Ieșire");

            System.out.println("Selectează o opțiune:");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addTable();
                    break;
                case 2:
                    removeTable();
                    break;
                case 3:
                    modifyTable();
                    break;
                case 4:
                    restaurant.displayFeedback();
                    break;
                case 0:
                    System.out.println("Ieșire...");
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
            }
        } while (option != 0);
    }

    // Metoda pentru adăugarea unei mese
    private void addTable() {
        System.out.println("Introdu ID-ul mesei:");
        int tableID = new Scanner(System.in).nextInt();

        // Verificăm dacă ID-ul există deja
        for (Tische table : restaurant.getTischeList()) {
            if (table.getID_Tisch() == tableID) {
                System.out.println("ID-ul mesei există deja. Te rugăm să introduci un alt ID.");
                return;
            }
        }

        System.out.println("Introdu numărul de locuri:");
        int numberOfSeats = new Scanner(System.in).nextInt();

        Tische newTable = new Tische(tableID);
        newTable.setAnzahl_der_Personen(numberOfSeats); // Presupunând că Tische oferă o metodă setNumberOfSeats
        restaurant.addTisch(newTable);
    }




    // Metoda pentru ștergerea unei mese
    private void removeTable() {
        System.out.println("Introdu numărul mesei de șters:");
        int tableNumber = new Scanner(System.in).nextInt();
        restaurant.removeTable(tableNumber);
    }

    // Metoda pentru modificarea unei mese
    private void modifyTable() {
        System.out.println("Introdu numărul mesei de modificat:");
        int tableNumber = new Scanner(System.in).nextInt();
        System.out.println("Introdu noul număr de locuri:");
        int newNumberOfSeats = new Scanner(System.in).nextInt();
        restaurant.modifyTable(tableNumber, newNumberOfSeats);
    }

    @Override
    public void processConnection() {
        System.out.println("Conectat ca manager.");
        processInput();
    }
}
