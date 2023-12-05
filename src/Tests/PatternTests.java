//package Tests;
//
//import Domain.Bestellung_im_Restaurant;
//import Domain.Kurierfirmen;
//import Factory.Employee;
//import Factory.EmployeeFactory;
//import Observer.BestellungUpdateLogger;
//import Singleton.KurierfirmenSingleton;
//import Strategy.Lieferkontext;
//import Strategy.TransportType;
//
//
//import java.util.Date;
//
//public class PatternTests {
//
//
////    public void testObserverPattern() {
////        Bestellung_im_Restaurant bestellung = new Bestellung_im_Restaurant(1, new Date(), preis);
////        BestellungUpdateLogger bestellungLogger = new BestellungUpdateLogger();
////        bestellung.addObserver(bestellungLogger);
////
////        bestellung.updateBestellungPreis(bestellung.getPreis());
////
////        String lastUpdate = bestellungLogger.getLastUpdate();
////        if (!"Noile detalii pentru comanda".equals(lastUpdate)) {
////            throw new AssertionError("Actualizare incorecta: " + lastUpdate);
////        }
////
////        Bestellung_im_Restaurant newBestellung = new Bestellung_im_Restaurant(2, new Date(), bestellung.getPreis());
////        bestellung.notifyObservers(newBestellung);
////
////        lastUpdate = bestellungLogger.getLastUpdate();
////        if (!"Detalii comanda noua".equals(lastUpdate)) {
////            throw new AssertionError("Actualizare incorecta: " + lastUpdate);
////        }
////    }
////
////
//
//
//    public void testFactoryPattern() {
//        Employee waiter = EmployeeFactory.createWaiter(1, "Vasile Ana", "Strada Aia", new Date(), "0756906733");
//
//        if (waiter == null || waiter.getID() != 1 || !waiter.getName().startsWith("Vasile") ||
//                !waiter.getAddress().startsWith("Strada") || waiter.getPhoneNumber() != "0756906733") {
//            throw new AssertionError("Atributele trebuie sa fie valabile");
//        }
//
//        Employee chef = EmployeeFactory.createChef(2, "Ion Ioan", "Strada Asta", new Date(), "0766306121");
//
//        if (chef == null || chef.getID() != 2 || !chef.getName().startsWith("Ion") ||
//                !chef.getAddress().startsWith("Strada") || chef.getPhoneNumber() != "0766306121") {
//            throw new AssertionError("Atributele trebuie sa fie valabile");
//        }
//
//        Employee barman = EmployeeFactory.createBarman(3, "Alina Gheorghe", "Strada Cealalta", new Date(), "0733405499");
//
//        if (barman == null || barman.getID() != 3 || !barman.getName().startsWith("Alina") ||
//                !barman.getAddress().startsWith("Strada") || barman.getPhoneNumber() != "0733405499") {
//            throw new AssertionError("Atributele trebuie sa fie valabile");
//        }
//    }
//
//    public void testSingletonPattern() {
//        Kurierfirmen kurierfirmen1 = KurierfirmenSingleton.getInstance();
//        Kurierfirmen kurierfirmen2 = KurierfirmenSingleton.getInstance();
//
//        if (kurierfirmen1 != kurierfirmen2 || kurierfirmen1 == null) {
//            throw new AssertionError("Instantele pentru Singleton ar trebui sa fie egale si sa nu fie nulle");
//        }
//    }
//    public void testStrategyPattern() {
//        Kurierfirmen kurierfirmen = new Kurierfirmen();
//
//        Lieferkontext lieferzustand = new Lieferkontext();
//        ((Lieferkontext) lieferzustand).setDeliveryTransport(TransportType.MASINA);
//
//        kurierfirmen.setLieferkontext(lieferzustand);
//
//        lieferzustand.handleDeliveryType(kurierfirmen);
//
//        if (kurierfirmen.getLieferzustand() != null && kurierfirmen.getLieferzustand().isInDeliveryState()) {
//            System.out.println("Sistemul este in starea de livrare");
//        } else {
//            System.out.println("Sistemul nu este in starea de livrare");
//            throw new AssertionError("Sistemul ar trebui sa fie in starea de livrare");
//        }
//    }
//
//
//    public static void main(String[] args) {
//        PatternTests tests = new PatternTests();
//        tests.testFactoryPattern();
//        //tests.testObserverPattern();
//        tests.testSingletonPattern();
//        tests.testStrategyPattern();
//    }
//
//}