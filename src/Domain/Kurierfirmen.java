package Domain;

import Strategy.Lieferkontext;
import Strategy.Lieferzustand;
import Strategy.TransportType;

public class Kurierfirmen {
    private int ID_Kurierfirma;
    private String Kuriername;
    private int ID_Kurier;

    private Lieferzustand lieferzustand;

    private static int lastUsedId = 0;

    private int generateUniqueId() {
        return lastUsedId++;
    }
    private Lieferkontext deliveryContext = new Lieferkontext();

    private TransportType transportType;

    public Kurierfirmen() {
        this.ID_Kurierfirma = generateUniqueId();
        this.Kuriername = "Vasile";
        this.transportType = TransportType.MASINA;

    }


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

    public void setDeliveryState(Lieferzustand deliveryState) {
        this.deliveryContext.setDeliveryState(deliveryState);
    }


    public void setDeliveryTransport() {
        this.transportType = TransportType.getRandomTransportType();
    }


    public TransportType getTransportType() {
        return transportType;
    }

    public Lieferzustand getLieferzustand() {
        return lieferzustand;
    }

    public void setLieferzustand(Lieferzustand lieferzustand) {
        this.lieferzustand = lieferzustand;
    }

    @Override
    public String toString() {
        return "Kurierfirma{ID_Kurierfirma=" + ID_Kurierfirma + ", Kuriername=" + Kuriername + ", TransportType=" + transportType + "}";
    }
}