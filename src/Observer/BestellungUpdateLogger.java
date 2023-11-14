package Observer;

import Domain.Bestellung_im_Restaurant;

public class BestellungUpdateLogger implements BestellungObserver {
    public String updateBestellung;
    private String lastUpdate;

    @Override
    public void updateBestellung(Bestellung_im_Restaurant updatedBestellung) {
        lastUpdate = String.valueOf(updatedBestellung.getDetails());
        System.out.println("Comanda actualizata: " + lastUpdate);
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}