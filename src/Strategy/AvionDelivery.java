package Strategy;

import Domain.Kurierfirmen;

public class AvionDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare cu avionul");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}