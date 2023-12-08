package Domain;

import java.util.Date;

public class Feedback {
    private int ID_Feedback;
    private int Anzahl_der_Sterne;
    private Date Datum;
    private int ID_Kunde;
    private int ID_Mitarbeiter;



    public int getID_Feedback() {
        return ID_Feedback;
    }

    public void setID_Feedback(int ID_Feedback) {
        this.ID_Feedback = ID_Feedback;
    }

    public int getAnzahl_der_Sterne() {
        return Anzahl_der_Sterne;
    }

    public void setAnzahl_der_Sterne(int Anzahl_der_Sterne) {
        this.Anzahl_der_Sterne = Anzahl_der_Sterne;
    }

    public java.sql.Date getDatum() {
        return (java.sql.Date) Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }

    public int getID_Kunde() {
        return ID_Kunde;
    }

    public void setID_Kunde(int ID_Kunde) {
        this.ID_Kunde = ID_Kunde;
    }

    public int getID_Mitarbeiter() {
        return ID_Mitarbeiter;
    }

    public void setID_Mitarbeiter(int ID_Mitarbeiter) {
        this.ID_Mitarbeiter = ID_Mitarbeiter;
    }

    @Override
    public String toString() {
        return "Feedback{ID_Feedback=" + ID_Feedback + ", Anzahl_der_Sterne=" + Anzahl_der_Sterne + ", Datum= " + Datum + ", ID_Kunde= " + ID_Kunde + ",ID_Mitarbeiter= " + ID_Mitarbeiter + "}";
    }
}