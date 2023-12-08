package Domain;

import java.util.Date;

public class Gericht_im_Bestellung_im_Restaurant {
    private int ID_Gericht_im_Restaurant;
    private int ID_Gericht;
    private Date Lieferzeit;

    public int getID_Online_Bestellung() {
        return ID_Gericht_im_Restaurant;
    }

    public void setID_Online_Bestellung(int ID_Online_Bestellung) {
        this.ID_Gericht_im_Restaurant = ID_Online_Bestellung;
    }

    public int getID_Gericht() {
        return ID_Gericht;
    }

    public void setID_Gericht(int ID_Gericht) {
        this.ID_Gericht = ID_Gericht;
    }

    public Date getLieferzeit() {
        return Lieferzeit;
    }

    public void setLieferzeit(Date Lieferzeit) {
        this.Lieferzeit = Lieferzeit;
    }
}