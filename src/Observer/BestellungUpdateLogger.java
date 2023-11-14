package Observer;

import Domain.Bestellung_im_Restaurant;

public class BestellungUpdateLogger implements BestellungObserver {
    @Override
    public void updateBestellung(Bestellung_im_Restaurant updatedBestellung) {
        System.out.println("Comanda actualizata: " + updatedBestellung.getDetails());
    }

}
