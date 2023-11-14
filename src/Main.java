import Domain.Bestellung_im_Restaurant;
import Domain.Kurierfirmen;
import Factory.EmployeeFactory;
import Factory.Employee;
import Observer.BestellungUpdateLogger;
import Singleton.KurierfirmenSingleton;
import Strategy.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


// Observator
        Bestellung_im_Restaurant bestellung = new Bestellung_im_Restaurant(1, new Date(), "Detalii comanda");
        BestellungUpdateLogger bestellungLogger = new BestellungUpdateLogger();
        bestellung.addObserver(bestellungLogger);
        bestellung.updateBestellungDetails("Noi detalii comanda");
        Bestellung_im_Restaurant newBestellung = new Bestellung_im_Restaurant(2, new Date(), "Detalii comanda noua");
        bestellung.notifyObservers(newBestellung);
        System.out.println("\n\n");





// Factory
        Employee waiter = EmployeeFactory.createWaiter(1, "John Doe", "Strada Example", new Date(), "123456789");

        System.out.println("Waiter ID: " + waiter.getID());
        System.out.println("Waiter Name: " + waiter.getName());
        System.out.println("Waiter Address: " + waiter.getAddress());
        System.out.println("Waiter Hire Date: " + waiter.getHireDate());
        System.out.println("Waiter Phone Number: " + waiter.getPhoneNumber());
        System.out.println();

        Employee chef = EmployeeFactory.createChef(2, "Jane Smith", "Strada Another", new Date(), "987654321");

        System.out.println("Chef ID: " + chef.getID());
        System.out.println("Chef Name: " + chef.getName());
        System.out.println("Chef Address: " + chef.getAddress());
        System.out.println("Chef Hire Date: " + chef.getHireDate());
        System.out.println("Chef Phone Number: " + chef.getPhoneNumber());
        System.out.println();

        Employee barman = EmployeeFactory.createBarman(3, "Alice Johnson", "Strada Third", new Date(), "555555555");

        System.out.println("Barman ID: " + barman.getID());
        System.out.println("Barman Name: " + barman.getName());
        System.out.println("Barman Address: " + barman.getAddress());
        System.out.println("Barman Hire Date: " + barman.getHireDate());
        System.out.println("Barman Phone Number: " + barman.getPhoneNumber());
        System.out.println("\n\n");





// Singleton
        Kurierfirmen kurierfirmen = KurierfirmenSingleton.getInstance();
        System.out.println("\n\n");




// Strategy
        Kurierfirmen kurierfirmenn = new Kurierfirmen();

        Lieferzustand lieferzustand = new Bestellung_in_Vorbereitung_Zustand();
        ((Bestellung_in_Vorbereitung_Zustand) lieferzustand).setDeliveryTransport(TransportType.MASINA);

        lieferzustand.handleDeliveryType(kurierfirmenn);

    }
}