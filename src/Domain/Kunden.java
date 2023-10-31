package Domain;

public class Kunden {
    private int ID_Kunde;
    private String Name;
    private String Adresse;
    private long Telefonnummer;

    public int getID_Kunde() {
        return ID_Kunde;
    }

    public void setID_Kunde(int ID_Kunde) {
        this.ID_Kunde = ID_Kunde;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public long getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(long Telefonnummer) {
        this.Telefonnummer = Telefonnummer;
    }
}