package Domain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant {
    private List<Feedback> feedbackList = new ArrayList<>();
    private List<Tische> tables = new ArrayList<>();


    // Calea către fișierul de feedback-uri
    private static final String FEEDBACK_FILE_PATH = "C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\feedback.txt";

    // Restul codului din clasa...

    // Funcționalitate pentru adăugarea feedback-urilor
    public void addFeedback(int stars, Date date, int customerId, int employeeId) {
        Feedback feedback = new Feedback();
        feedback.setAnzahl_der_Sterne(stars);
        feedback.setDatum(date);
        feedback.setID_Kunde(customerId);
        feedback.setID_Mitarbeiter(employeeId);

        feedbackList.add(feedback);
        System.out.println("Feedback adăugat cu succes.");

        // Scrierea în fișier după adăugarea feedback-ului
        writeFeedbackToFile(feedback);
    }

    // Funcționalitate pentru afișarea feedback-urilor
    public void displayFeedback() {
        System.out.println("Feedback-uri:");
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback.getAnzahl_der_Sterne());
        }

        // Afișează feedback-urile din fișier
        displayFeedbackFromFile();
    }

    // Metoda pentru a scrie feedback-urile în fișier
    private void writeFeedbackToFile(Feedback feedback) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FEEDBACK_FILE_PATH, true))) {
            writer.println(feedback);  // Folosim metoda toString() din clasa Feedback
        } catch (IOException e) {
            System.out.println("Eroare la scrierea feedback-ului în fișier: " + e.getMessage());
        }
    }

    // Metoda pentru a afișa feedback-urile din fișier
    private void displayFeedbackFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FEEDBACK_FILE_PATH))) {
            String line;
            System.out.println("Feedback-uri din fișier:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea feedback-urilor din fișier: " + e.getMessage());
        }
    }

    // Funcționalitate pentru adăugarea unei mese
    public void addTisch(Tische newTable) {
        tables.add(newTable);
        System.out.println("Masa adăugată cu succes.");
        updateTablesFile("C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\tische.txt");
    }

    // Funcționalitate pentru ștergerea unei mese
    public void removeTable(int tableNumber) {
        tables.removeIf(table -> table.getTischeNumber() == tableNumber);
        System.out.println("Masa ștearsă cu succes.");
        updateTablesFile("C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\tische.txt");
    }

    // Funcționalitate pentru modificarea unei mese
    public void modifyTable(int tableNumber, int newNumberOfSeats) {
        for (Tische table : tables) {
            if (table.getTischeNumber() == tableNumber) {
                table.setAnzahl_der_Personen(newNumberOfSeats);
                System.out.println("Masa modificată cu succes.");
                updateTablesFile("C:\\Users\\Utilizator\\IdeaProjects\\RestaurantApp\\src\\tische.txt");
                return;
            }
        }
        System.out.println("Masa nu a fost găsită.");
    }

    // Metoda pentru a actualiza fișierul cu mese
    private void updateTablesFile(String fileName) {
        try {
            List<String> tableLines = new ArrayList<>();
            for (Tische table : tables) {
                tableLines.add(table.toString());
            }
            Files.write(Paths.get(fileName), tableLines);
        } catch (Exception e) {
            System.out.println("Eroare la actualizarea fișierului cu mese: " + e.getMessage());
        }
    }

    public void addFeedback(String feedbackContent) {
    }

    public Tische[] getTischeList() {
        return new Tische[0];
    }
}
