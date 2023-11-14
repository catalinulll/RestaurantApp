package Domain;

public class Tische {
    private int ID_Tisch;
    private int Anzahl_der_Personen;
    private static int count = 0;
    private int tischeNumber;
    private int id;

    public Tische(int Anzahl_der_Personen) {
        this.Anzahl_der_Personen = Anzahl_der_Personen;
        count++;
        tischeNumber = count;
        id = tischeNumber;
    }
    public int getId() {
        return id;
    }

    public int getTischeNumber() {
        return tischeNumber;
    }
    public int getID_Tisch() {
        return ID_Tisch;
    }

    public void setID_Tisch(int ID_Tisch) {
        this.ID_Tisch = ID_Tisch;
    }

    public int getAnzahl_der_Personen() {
        return Anzahl_der_Personen;
    }

    public void setAnzahl_der_Personen(int Anzahl_der_Personen) {
        this.Anzahl_der_Personen = Anzahl_der_Personen;
    }

    @Override
    public String toString() {
        return "Tische{TischeNumber=" + tischeNumber + ", Anzahl_der_Personen=" + Anzahl_der_Personen + "}";
    }
}