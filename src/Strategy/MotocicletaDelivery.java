package Strategy;

import Domain.Kurierfirmen;

public class MotocicletaDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare cu motocicleta");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}