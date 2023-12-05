package UI;

import Domain.Restaurant;

import java.util.Scanner;

public class ConnectionManager {
    private Restaurant restaurant;

    public ConnectionManager(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void connect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selectează tipul de conexiune:");
        System.out.println("1. Client");
        System.out.println("2. Manager");

        int option = scanner.nextInt();

        UserInterface connectionStrategy = null;

        switch (option) {
            case 1:
                connectionStrategy = new ClientConnectionStrategy(restaurant);
                break;
            case 2:
                System.out.println("Introdu parola de manager:");
                String password = scanner.next();
                if (validateManagerPassword(password)) {
                    connectionStrategy = new ManagerConnectionStrategy(restaurant);
                } else {
                    System.out.println("Parolă incorectă. Conexiune eșuată.");
                    return;
                }
                break;
            default:
                System.out.println("Opțiune invalidă. Conexiune eșuată.");
                return;
        }

        connectionStrategy.processConnection();
    }

    private boolean validateManagerPassword(String password) {
        // Introduceți aici logica pentru validarea parolei de manager
        // În mod ideal, aceasta ar trebui să fie comparată cu o valoare stocată securizat.
        return "parola".equals(password);
    }
}
