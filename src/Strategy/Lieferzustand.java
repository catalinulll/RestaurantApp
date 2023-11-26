package Strategy;

import Domain.Kurierfirmen;

public interface Lieferzustand {
    void handleDeliveryState(Kurierfirmen kurierfirmen);
    boolean isInDeliveryState();
}