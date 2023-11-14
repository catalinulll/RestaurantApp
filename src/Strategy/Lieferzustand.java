package Strategy;

import Domain.Kurierfirmen;

public interface Lieferzustand {
    void handleDeliveryType(Kurierfirmen kurierfirmen);

    boolean isInDeliveryState();
}