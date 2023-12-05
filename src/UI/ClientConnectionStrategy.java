package UI;

import Domain.Restaurant;
import Domain.Tische;

import java.io.*;
import java.util.Scanner;

public class ClientConnectionStrategy implements UserInterface {
    private Restaurant restaurant;

    public ClientConnectionStrategy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void displayMenu() {
        System.out.println("Meniu:");
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
            System.out.println("1. Rezervare masă");
            System.out.println("2. Afișare meniu");
            System.out.println("3. Plasare comandă");
            System.out.println("4. Feedback");
            System.out.println("0. Ieșire");

            System.out.println("Selectează o opțiune:");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    reserveTable();
                    break;
                case 2:
                    displayMenu();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    addFeedback();
                    break;
                case 0:
                    System.out.println("Ieșire...");
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
            }
        } while (option != 0);
    }

    // Metoda pentru rezervarea mesei
    private void reserveTable() {
        System.out.println("Introdu ID-ul mesei:");
        int tableId = new Scanner(System.in).nextInt();

        // Verificăm dacă masa cu ID-ul specificat există în fișier
        if (checkTableExistence(tableId)) {
            System.out.println("Masa rezervată cu succes.");
            // Puteți adăuga aici orice altă logică specifică rezervării mesei
        } else {
            System.out.println("Masa cu ID-ul specificat nu există.");
        }
    }

    // Metoda pentru verificarea existenței mesei în fișier
    // Metoda pentru verificarea existenței mesei în fișier
    private boolean checkTableExistence(int tableId) {
        String filePath = "C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\tische.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Deserializăm linia într-un obiect Tische
                Tische currentTable = deserializeTische(line);
                // Obținem ID-ul mesei curente
                int currentTableId = currentTable.getTischeNumber();

                // Verificați dacă ID-ul curent corespunde cu cel introdus de utilizator
                if (currentTableId == tableId) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea mesei din fișier: " + e.getMessage());
        }
        return false;
    }

    // Metoda pentru deserializarea unei linii într-un obiect Tische
    private Tische deserializeTische(String line) {
        // Îndepărtați parantezele și fragmentele inutile
        line = line.replace("Tische{TischeNumber=", "").replace("}", "");
        // Împărțiți linia într-un array de string-uri pe baza virgulelor
        String[] tableInfo = line.split(",");
        // Obțineți numărul mesei
        int tischeNumber = Integer.parseInt(tableInfo[0].trim());
        // Întoarceți un nou obiect Tische
        return new Tische(tischeNumber);
    }


    // Metoda pentru plasarea comenzii
    private void placeOrder() {
        System.out.println("Introdu ID-ul mesei pentru care plasezi comanda:");
        int tableId = new Scanner(System.in).nextInt();

        // Verificăm dacă masa cu ID-ul specificat există în fișier
        Tische reservedTable = getReservedTable(tableId);
        if (reservedTable != null) {
            // Aici poți adăuga logica specifică plasării comenzii pentru masa rezervată
            System.out.println("Comanda plasată cu succes.");
        } else {
            System.out.println("Masa cu ID-ul specificat nu există.");
        }
    }


    // Metoda pentru obținerea detaliilor mesei rezervate
    private Tische getReservedTable(int tableId) {
        String filePath = "C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\tische.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Deserializăm linia într-un obiect Tische
                Tische currentTable = deserializeTische(line);
                // Obținem ID-ul mesei curente
                int currentTableId = currentTable.getTischeNumber();

                // Verificați dacă ID-ul curent corespunde cu cel introdus de utilizator
                if (currentTableId == tableId) {
                    return currentTable;
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea mesei din fișier: " + e.getMessage());
        }
        return null; // Returnăm null în cazul în care masa nu a fost găsită
    }


    // Metoda pentru adăugarea feedback-ului
    private void addFeedback() {
        System.out.println("Introdu feedback-ul:");
        String feedbackContent = new Scanner(System.in).next();
        restaurant.addFeedback(feedbackContent);

        // Scrierea în fișier după adăugarea feedback-ului
        writeFeedbackToFile(feedbackContent);
    }

    // Metoda pentru a scrie feedback-ul în fișier
    private void writeFeedbackToFile(String feedbackContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\feedback.txt", true))) {
            writer.write(feedbackContent);
            writer.newLine();
            System.out.println("Feedback scris în fișier cu succes.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }

    @Override
    public void processConnection() {
        System.out.println("Conectat ca client.");
        processInput();
    }
}
