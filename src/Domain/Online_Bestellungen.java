package Domain;

public class Online_Bestellungen {
    private int ID_Online_Bestellung;
    private String Adresse;
    private float Preis;
    private int ID_Kunde;
    private int ID_Kurierfirma;

    public int getID_Online_Bestellung() {
        return ID_Online_Bestellung;
    }

    public void setID_Online_Bestellung(int ID_Online_Bestellung) {
        this.ID_Online_Bestellung = ID_Online_Bestellung;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public float getPreis() {
        return Preis;
    }

    public void setPreis(float Preis) {
        this.Preis = Preis;
    }

    public int getID_Kunde() {
        return ID_Kunde;
    }

    public void setID_Kunde(int ID_Kunde) {
        this.ID_Kunde = ID_Kunde;
    }

    public int getID_Kurierfirma() {
        return ID_Kurierfirma;
    }

    public void setID_Kurierfirma(int ID_Kurierfirma) {
        this.ID_Kurierfirma = ID_Kurierfirma;
    }
}
