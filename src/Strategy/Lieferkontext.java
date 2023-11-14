package Strategy;

import Domain.Kurierfirmen;

public class Lieferkontext {
    private Lieferzustand deliveryState;
    private TransportType deliveryTransport;

    public void setDeliveryState(Lieferzustand deliveryState) {
        this.deliveryState = deliveryState;
    }

    public void setDeliveryTransport(TransportType transportType) {
        this.deliveryTransport = transportType;
    }

}