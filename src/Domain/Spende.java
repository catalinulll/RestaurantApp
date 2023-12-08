package Domain;

public class Spende {
    private int ID_Spende;
    private String Adresse;
    private int ID_Gericht;
    private int Portionenanzahl;

    public int getID_Spende() {
        return ID_Spende;
    }

    public void setID_Spende(int ID_Spende) {
        this.ID_Spende = ID_Spende;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getID_Gericht() {
        return ID_Gericht;
    }

    public void setID_Gericht(int ID_Gericht) {
        this.ID_Gericht = ID_Gericht;
    }

    public int getPortionenanzahl() {
        return Portionenanzahl;
    }

    public void setPortionenanzahl(int Portionenanzahl) {
        this.Portionenanzahl = Portionenanzahl;
    }

    public String getField1() {
        return null;
    }

    public String getField2() {
        return null;
    }
}