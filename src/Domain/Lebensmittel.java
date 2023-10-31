package Domain;

public class Lebensmittel {
    private int ID_Lebensmittel;
    private String Name_Lebensmittel;
    private int Quantitat;

    public int getID_Lebensmittel() {
        return ID_Lebensmittel;
    }

    public void setID_Lebensmittel(int ID_Lebensmittel) {
        this.ID_Lebensmittel = ID_Lebensmittel;
    }

    public String getName_Lebensmittel() {
        return Name_Lebensmittel;
    }

    public void setName_Lebensmittel(String Name_Lebensmittel) {
        this.Name_Lebensmittel = Name_Lebensmittel;
    }

    public int getQuantitat() {
        return Quantitat;
    }

    public void setQuantitat(int Quantitat) {
        this.Quantitat = Quantitat;
    }
}
