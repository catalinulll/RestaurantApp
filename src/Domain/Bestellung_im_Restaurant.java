package Domain;


import Observer.BestellungSubject;

import java.util.Date;

public class Bestellung_im_Restaurant extends BestellungSubject {
    private int bestellungID;
    private Date data;
    private String details;

    public Bestellung_im_Restaurant(int bestellungID, Date data, String details) {
        this.bestellungID = bestellungID;
        this.data = data;
        this.details = details;
    }

    public int getBestellungID() {
        return bestellungID;
    }

    public Date getData() {
        return data;
    }

    public String getDetails() {
        return details;
    }

    public void updateBestellungDetails(String newDetails) {
        this.details = newDetails;

        notifyObservers(this);
    }

    public void notifyObservers(Bestellung_im_Restaurant updatedBestellung) {
        super.notifyObservers(updatedBestellung);
    }


    public void setID_Bestellung_im_Restaurant(int nextId) {
    }

    public int getID_Bestellung_im_Restaurant() {
        return bestellungID;
    }
}