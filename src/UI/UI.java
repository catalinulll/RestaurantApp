package UI;

import Domain.Restaurant;

public class UI {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        ConnectionManager connectionManager = new ConnectionManager(restaurant);
        connectionManager.connect();
    }
}
