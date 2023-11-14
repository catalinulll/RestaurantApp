package UI;
import Controller.Bestellung_im_Restaurant_Controller;
import Controller.Kurierfirmen_Controller;
import Controller.Tische_Controller;
import Domain.Bestellung_im_Restaurant;
import Domain.Kurierfirmen;
import Domain.Tische;
import Exceptions.EntityNotFoundException;
import Repository.InMemoryRepository;
import Repository.Repository;
import Repository.Kurierfirmen_Repo;
import Singleton.KurierfirmenSingleton;
import Strategy.Bestellung_in_Vorbereitung_Zustand;
import Strategy.TransportType;
import Repository.Bestellung_im_Restaurant_Repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Alegeti tabelul cu care doriti sa lucrati:");
            System.out.println("1. Tische");
            System.out.println("2. Kurierfirmen");
            System.out.println("3. Bestellung_im_Restaurant");
            System.out.println("4. Gericht");
            System.out.println("5. Gericht_im_Bestellung_im_Restaurant");
            System.out.println("6. Gericht_im_Online_Bestellung");
            System.out.println("7. Kunden");
            System.out.println("8. Kundenkarte");
            System.out.println("9. Feedback");
            System.out.println("10. Lebensmittel_im_Essen");
            System.out.println("11. Lebensmittel");
            System.out.println("12. Mitarbeiter");
            System.out.println("13. Online_Bestellungen");
            System.out.println("14. Spende");
            System.out.println("15. Iesire");

            System.out.print("Alegeti optiunea: ");
            int tableChoice = scanner.nextInt();

            switch (tableChoice) {
                case 1:
                    workWithTische();
                    break;

                case 2:
                    workWithKurierfirmen();
                    break;

                case 3:
                    workWithBestellungImRestaurant();
                    break;

                case 4:
                    System.out.println("Iesire din aplicatie");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Optiune invalida. Alegeti din nou");
            }
        }
    }

    private static void workWithTische() {
        Repository<Tische> tischeRepository = new InMemoryRepository<Tische>();
        Tische_Controller tischeController = new Tische_Controller(tischeRepository);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\t   Mese");
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
                            System.out.println("Masa nu a fost gasita");
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
                        System.out.println("Masa actualizata");
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
                    System.out.println("Optiune invalida. Alegeti din nou");
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

    private static void workWithKurierfirmen() {
        Repository<Kurierfirmen> kurierfirmenRepository = new Kurierfirmen_Repo();
        Kurierfirmen_Controller kurierfirmenController = new Kurierfirmen_Controller(kurierfirmenRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t   Kurierfirmen");
            System.out.println("1. Adaugare firma de curierat");
            System.out.println("2. Cautare firma de curierat dupa ID");
            System.out.println("3. Strategy Pattern + Actualizare firma de curierat");
            System.out.println("4. Stergere firma de curierat");
            System.out.println("5. Afisare toate firmele de curierat");
            System.out.println("6. Singleton Pattern");
            System.out.println("7. Inapoi");

            System.out.print("Alegeti optiunea: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Kurierfirmen kurierfirmen = createKurierfirmen();
                    kurierfirmenController.create(kurierfirmen);
                    System.out.println("Firma de curierat adaugata");
                    break;

                case 2:
                    System.out.print("Introduceti ID-ul firmei de curierat cautate: ");
                    int id = scanner.nextInt();
                    try {
                        Kurierfirmen foundKurierfirmen = kurierfirmenController.read(id);
                        if (foundKurierfirmen != null) {
                            System.out.println("Firma de curierat gasita: " + foundKurierfirmen);
                        } else {
                            System.out.println("Firma de curierat nu a fost gasita");
                        }
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Introduceti ID-ul firmei de curierat pe care doriti sa o actualizati: ");
                    int updateId = scanner.nextInt();

                    try {
                        Kurierfirmen existingKurierfirmen = kurierfirmenController.read(updateId);

                        System.out.print("Introduceti noul nume al curierului: ");
                        String newKurierfirmenName = scanner.next();
                        existingKurierfirmen.setKuriername(newKurierfirmenName);

                        Bestellung_in_Vorbereitung_Zustand bestellungInVorbereitung = new Bestellung_in_Vorbereitung_Zustand();
                        bestellungInVorbereitung.setDeliveryTransport(TransportType.getRandomTransportType());

                        existingKurierfirmen.setDeliveryState(bestellungInVorbereitung);


                        kurierfirmenController.update(existingKurierfirmen);
                        System.out.println("Firma de curierat actualizata");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Introduceti ID-ul firmei de curierat de sters: ");
                    int deleteId = scanner.nextInt();
                    try {
                        kurierfirmenController.delete(deleteId);
                        System.out.println("Firma de curierat stearsa");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    List<Kurierfirmen> allKurierfirmen = kurierfirmenController.getAll();
                    System.out.println("Toate firmele de curierat:");
                    for (Kurierfirmen k : allKurierfirmen) {
                        k.setDeliveryTransport();
                        System.out.println(k);
                    }
                    break;

                case 6:
                    Kurierfirmen singletonInstance = KurierfirmenSingleton.getInstance();
                    System.out.println("Am obtinut instanta Singleton pentru Kurierfirmen: " + singletonInstance);
                    break;

                case 7:
                    System.out.println("Inapoi la alegerea tabelului");
                    return;

                default:
                    System.out.println("Optiune invalida. Alegeti din nou");
            }
        }
    }

    private static Kurierfirmen createKurierfirmen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numele curierului: ");
        String kurierfirmenName = scanner.next();

        Kurierfirmen kurierfirmen = new Kurierfirmen();
        kurierfirmen.setKuriername(kurierfirmenName);

        return kurierfirmen;
    }

    private static void workWithBestellungImRestaurant() {
        Repository<Bestellung_im_Restaurant> bestellungRepository = new Bestellung_im_Restaurant_Repo();
        Bestellung_im_Restaurant_Controller bestellungController = new Bestellung_im_Restaurant_Controller(bestellungRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t   Bestellung_im_Restaurant");
            System.out.println("1. Adaugare comanda in restaurant");
            System.out.println("2. Cautare comanda in restaurant dupa ID");
            System.out.println("3. Actualizare comanda in restaurant");
            System.out.println("4. Stergere comanda in restaurant");
            System.out.println("5. Afisare toate comenzile in restaurant");
            System.out.println("6. Inapoi");

            System.out.print("Alegeti optiunea: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Bestellung_im_Restaurant bestellung = createBestellungImRestaurant();
                    bestellungController.create(bestellung);
                    System.out.println("Comanda in restaurant adaugata");
                    break;

                case 2:
                    System.out.print("Introduceti ID-ul comenzii in restaurant cautate: ");
                    int id = scanner.nextInt();
                    try {
                        Bestellung_im_Restaurant foundBestellung = bestellungController.read(id);
                        if (foundBestellung != null) {
                            System.out.println("Comanda in restaurant gasita: " + foundBestellung);
                        } else {
                            System.out.println("Comanda in restaurant nu a fost gasita");
                        }
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Introduceti ID-ul comenzii in restaurant pe care doriti sa o actualizati: ");
                    int updateId = scanner.nextInt();
                    try {
                        Bestellung_im_Restaurant existingBestellung = bestellungController.read(updateId);


                        bestellungController.update(existingBestellung);
                        System.out.println("Comanda in restaurant actualizata");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Introduceti ID-ul comenzii in restaurant de sters: ");
                    int deleteId = scanner.nextInt();
                    try {
                        bestellungController.delete(deleteId);
                        System.out.println("Comanda in restaurant stearsa");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    List<Bestellung_im_Restaurant> allBestellungen = bestellungController.getAll();
                    System.out.println("Toate comenzile in restaurant:");
                    for (Bestellung_im_Restaurant b : allBestellungen) {
                        System.out.println(b);
                    }
                    break;

                case 6:
                    System.out.println("Inapoi la alegerea tabelului");
                    return;

                default:
                    System.out.println("Optiune invalida. Alegeti din nou");
            }
        }
    }

    private static Bestellung_im_Restaurant createBestellungImRestaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti ID-ul comenzii in restaurant: ");
        int bestellungID = scanner.nextInt();

        System.out.print("Introduceti data comenzii in restaurant ('yyyy-MM-dd'): ");
        String dataString = scanner.next();

        Date data;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            data = dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formatul datei este invalid. Utilizati 'yyyy-MM-dd'");
            return null;
        }

        System.out.print("Introduceti detalii pentru comanda in restaurant: ");
        String details = scanner.next();

        return new Bestellung_im_Restaurant(bestellungID, data, details);
    }
}