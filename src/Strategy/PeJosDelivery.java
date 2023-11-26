package Strategy;

import Domain.Kurierfirmen;

public class PeJosDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare pe jos");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}