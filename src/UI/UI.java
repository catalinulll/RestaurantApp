package UI;
import Controller.Tische_Controller;
import Domain.Tische;
import Exceptions.EntityNotFoundException;
import Repository.InMemoryRepository;
import Repository.Repository;
import java.util.List;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Repository<Tische> tischeRepository = new InMemoryRepository<Tische>();
        Tische_Controller tischeController = new Tische_Controller(tischeRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\tMeniu");
            System.out.println("1. Adaugare masa");
            System.out.println("2. Cautare masa dupa ID");
            System.out.println("3. Actualizare masa");
            System.out.println("4. Stergere masa");
            System.out.println("5. Afisare toate mesele");
            System.out.println("6. Iesire");

            System.out.print("Alegeti optiunea: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Tische tische = createTische();
                    tischeController.create(tische);
                    System.out.println("Masa adaugata");
                    break;

                case 2:
                    System.out.print("Introduceti ID-ul mesei cautate: ");
                    int id = scanner.nextInt();
                    try {
                        Tische foundTische = tischeController.read(id);
                        if (foundTische != null) {
                            System.out.println("Masa gasita: " + foundTische);
                        } else {
                            System.out.println("Masa nu a fost gasita.");
                        }
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Introduceti ID-ul mesei pe care doriti sa o actualizati: ");
                    int updateId = scanner.nextInt();

                    try {
                        Tische existingTische = tischeController.read(updateId);

                        System.out.print("Introduceti noul numar de persoane: ");
                        int newAnzahlDerPersonen = scanner.nextInt();
                        existingTische.setAnzahl_der_Personen(newAnzahlDerPersonen);
                        tischeController.update(existingTische);
                        System.out.println("Masa actualizata.");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;



                case 4:
                    System.out.print("Introduceti ID-ul mesei de sters: ");
                    int deleteId = scanner.nextInt();
                    try {
                        tischeController.delete(deleteId);
                        System.out.println("Masa stearsa");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    List<Tische> allTische = tischeController.getAll();
                    System.out.println("Toate mesele:");
                    for (Tische t : allTische) {
                        System.out.println(t);
                    }
                    break;

                case 6:
                    System.out.println("Iesire din aplicatie");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Optiune invalida. Alegeți din nou.");
            }
        }
    }

    private static Tische createTische() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti Anzahl_der_Personen: ");
        int anzahlDerPersonen = scanner.nextInt();

        Tische tische = new Tische(anzahlDerPersonen);
        tische.setAnzahl_der_Personen(anzahlDerPersonen);

        return tische;
    }
}
