package com.kodilla.good.patterns.challenges.freshfood.distributors;

import com.kodilla.good.patterns.challenges.freshfood.Order;

public class HealthyShop implements FoodDistributor {
    private static final String NAME = "Healthy Shop";

    @Override
    public void process(Order order) {
        if (order.getFoodDistributor()==this) {
            System.out.println("Zamówienie numer " + order.getOrderNumber() + " zostało zrealizowane!");
            summary(order);
        } else {
            System.out.println("Zamówienie " + order.getOrderNumber() + " nie zostało zrealizowane. Skontaktuj się z contact@healthyshop.com");
        }
    }

    @Override
    public String toString() {
        return NAME;
    }
}
