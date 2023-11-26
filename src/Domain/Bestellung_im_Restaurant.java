package Domain;


import Observer.BestellungSubject;

import java.util.Date;

public class Bestellung_im_Restaurant extends BestellungSubject {
    private int bestellungID;
    private Date data;
    private float preis;

    public Bestellung_im_Restaurant(int bestellungID, Date data, float preis) {
        this.bestellungID = bestellungID;
        this.data = data;
        this.preis = preis;
    }

    public int getBestellungID() {
        return bestellungID;
    }

    public Date getData() {
        return data;
    }

    public float getPreis() {
        return preis;
    }

    public void updateBestellungPreis(float neue_preis) {
        this.preis = neue_preis;

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

    @Override
    public String toString() {
        return "Bestellung_im_Restaurant{ID_Bestellung=" + bestellungID + ", Date=" + data + ", Preis=" + preis + "}";
    }
}