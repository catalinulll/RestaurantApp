package Domain;

import java.util.Date;

public class Gericht_im_Online_Bestellung {
    private int ID_Online_Bestellung;
    private int ID_Gericht;
    private Date Tischservicezeit;

    public int getID_Gericht_im_Restaurant() {
        return ID_Online_Bestellung;
    }

    public void setID_Gericht_im_Restaurant(int ID_Gericht_im_Restaurant) {
        this.ID_Online_Bestellung = ID_Gericht_im_Restaurant;
    }

    public int getID_Gericht() {
        return ID_Gericht;
    }

    public void setID_Gericht(int ID_Gericht) {
        this.ID_Gericht = ID_Gericht;
    }

    public Date getTischservicezeit() {
        return Tischservicezeit;
    }

    public void setTischservicezeit(Date Tischservicezeit) {
        this.Tischservicezeit = Tischservicezeit;
    }
}