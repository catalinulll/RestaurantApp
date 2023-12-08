package Strategy;

import Domain.Kurierfirmen;

public class BicicletaDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare cu bicicleta");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}
