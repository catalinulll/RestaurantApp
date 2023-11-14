package Domain;

public class Gericht {
    private int ID_Gericht;
    private String Name;
    private String Typ;
    private float Preis;

    public int getID_Gericht() {
        return ID_Gericht;
    }

    public void setID_Gericht(int ID_Gericht) {
        this.ID_Gericht = ID_Gericht;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String Typ) {
        this.Typ = Typ;
    }

    public float getPreis() {
        return Preis;
    }

    public void setPreis(float Preis) {
        this.Preis = Preis;
    }
}
