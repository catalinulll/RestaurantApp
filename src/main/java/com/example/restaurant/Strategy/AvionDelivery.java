package main.java.com.example.restaurant.Strategy;

import com.example.restaurant.Domain.Kurierfirmen;

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