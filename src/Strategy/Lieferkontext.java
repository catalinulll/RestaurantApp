package Strategy;

import Domain.Kurierfirmen;

public class Lieferkontext {
    private TransportType transportType;

    public void setDeliveryTransport(TransportType transportType) {
        this.transportType = transportType;
    }

    public void handleDeliveryType(Kurierfirmen kurierfirmen) {
        System.out.println("Tip de transport: " + transportType);
    }

    public boolean isInDeliveryState() {
        return transportType != null;
    }
}