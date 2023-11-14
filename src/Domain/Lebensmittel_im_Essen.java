package Domain;

public class Lebensmittel_im_Essen {
    private int ID_Lebensmittel_im_Essen;
    private int ID_Gericht;
    private String Name_Lebensmittel;

    public int getID_Lebensmittel_im_Essen() {
        return ID_Lebensmittel_im_Essen;
    }

    public void setID_Lebensmittel_im_Essen(int ID_Lebensmittel_im_Essen) {
        this.ID_Lebensmittel_im_Essen = ID_Lebensmittel_im_Essen;
    }

    public int getID_Gericht() {
        return ID_Gericht;
    }

    public void setID_Gericht(int ID_Gericht) {
        this.ID_Gericht = ID_Gericht;
    }

    public String getName_Lebensmittel() {
        return Name_Lebensmittel;
    }

    public void setName_Lebensmittel(String Name_Lebensmittel) {
        this.Name_Lebensmittel = Name_Lebensmittel;
    }
}