package Strategy;

import Domain.Kurierfirmen;

public class Bestellung_in_Vorbereitung_Zustand implements Lieferzustand {
    private TransportType transportType;

    public void setDeliveryTransport(TransportType transportType) {
        this.transportType = transportType;
    }

    @Override
    public void handleDeliveryType(Kurierfirmen kurierfirmen) {
        System.out.println("Tip de transport: " + transportType);
    }

    @Override
    public boolean isInDeliveryState() {
        return transportType != null;
    }
}