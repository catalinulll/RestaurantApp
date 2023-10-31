package Domain;

public class Bestellung_im_Restaurant {
    private int ID_Bestellung_im_Restaurant;
    private int ID_Tisch;
    private float Preis;
    private int ID_Mitarbeiter;

    public int getID_Bestellung_im_Restaurant() {
        return ID_Bestellung_im_Restaurant;
    }

    public void setID_Bestellung_im_Restaurant(int ID_Bestellung_im_Restaurant) {
        this.ID_Bestellung_im_Restaurant = ID_Bestellung_im_Restaurant;
    }

    public int getID_Tisch() {
        return ID_Tisch;
    }

    public void setID_Tisch(int ID_Tisch) {
        this.ID_Tisch = ID_Tisch;
    }

    public float getPreis() {
        return Preis;
    }

    public void setPreis(float Preis) {
        this.Preis = Preis;
    }

    public int getID_Mitarbeiter() {
        return ID_Mitarbeiter;
    }

    public void setID_Mitarbeiter(int ID_Mitarbeiter) {
        this.ID_Mitarbeiter = ID_Mitarbeiter;
    }
}
