package Observer;

import Domain.Bestellung_im_Restaurant;

public interface BestellungObserver {
    void updateBestellung(Bestellung_im_Restaurant updatedBestellung);
}