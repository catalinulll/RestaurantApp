package Domain;

import java.util.Date;

public class Mitarbeiter  {
    private int ID_Mitarbeiter;
    private String Name;
    private String Adresse;
    private Date Einstellungdatum;
    private long Telefonnummer;
    private String Beruf;

    public Mitarbeiter(int ID_Mitarbeiter, String Name, String Adresse, Date Einstellungdatum, long Telefonnummer, String Beruf) {
        this.ID_Mitarbeiter = ID_Mitarbeiter;
        this.Name = Name;
        this.Adresse = Adresse;
        this.Einstellungdatum = Einstellungdatum;
        this.Telefonnummer = Telefonnummer;
        this.Beruf = Beruf;
    }


    public int getID_Mitarbeiter() {
        return ID_Mitarbeiter;
    }

    public void setID_Mitarbeiter(int ID_Mitarbeiter) {
        this.ID_Mitarbeiter = ID_Mitarbeiter;
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

    public Date getEinstellungdatum() {
        return Einstellungdatum;
    }

    public void setEinstellungdatum(Date Einstellungdatum) {
        this.Einstellungdatum = Einstellungdatum;
    }

    public long getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(long Telefonnummer) {
        this.Telefonnummer = Telefonnummer;
    }

    public String getBeruf() {
        return Beruf;
    }

    public void setBeruf(String Beruf) {
        this.Beruf = Beruf;
    }

}