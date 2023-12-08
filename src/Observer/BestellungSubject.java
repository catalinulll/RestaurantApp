package Observer;

import Domain.Bestellung_im_Restaurant;

import java.util.ArrayList;
import java.util.List;

public class BestellungSubject {
    private List<BestellungObserver> observers = new ArrayList<>();

    public void addObserver(BestellungObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BestellungObserver observer) {
        observers .remove(observer);
    }

    public void notifyObservers(Bestellung_im_Restaurant updatedBestellung) {
        for (BestellungObserver observer : observers) {
            observer.updateBestellung(updatedBestellung);
        }
    }
}