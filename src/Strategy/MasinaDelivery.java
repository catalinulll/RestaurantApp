package Strategy;

import Domain.Kurierfirmen;

public class MasinaDelivery implements Lieferzustand {
    @Override
    public void handleDeliveryState(Kurierfirmen kurierfirmen) {
        System.out.println("Livrare cu masina");
    }

    @Override
    public boolean isInDeliveryState() {
        return true;
    }
}
