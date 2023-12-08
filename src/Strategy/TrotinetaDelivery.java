package Strategy;

import Domain.Kurierfirmen;

public class TrotinetaDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare cu trotineta");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}
