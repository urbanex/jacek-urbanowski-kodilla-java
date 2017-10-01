package com.kodilla.good.patterns.challenges.freshfood;

public interface FoodDistributor {
    default void summary(Order order) {
        System.out.println("SZCZEGÓŁY ZAMÓWIENIA:\ndostawca: " + order.getProvider().getName()
                + "\ntowar: " + order.getProduct().getProductName() + "\nilość: " + order.getQuantity()
                + "\nid klienta: " + order.getCustomer().getCustomerId());
    }

    void process(Order order);
}
