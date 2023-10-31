package Domain;

public class Kurierfirmen {
    private int ID_Kurierfirma;
    private String Kuriername;
    private int ID_Kurier;

    public int getID_Kurierfirma() {
        return ID_Kurierfirma;
    }

    public void setID_Kurierfirma(int ID_Kurierfirma) {
        this.ID_Kurierfirma = ID_Kurierfirma;
    }

    public String getKuriername() {
        return Kuriername;
    }

    public void setKuriername(String Kuriername) {
        this.Kuriername = Kuriername;
    }

    public int getID_Kurier() {
        return ID_Kurier;
    }

    public void setID_Kurier(int ID_Kurier) {
        this.ID_Kurier = ID_Kurier;
    }
}