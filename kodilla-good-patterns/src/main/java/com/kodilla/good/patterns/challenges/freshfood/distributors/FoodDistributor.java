package com.kodilla.good.patterns.challenges.freshfood.distributors;

import com.kodilla.good.patterns.challenges.freshfood.Order;

import java.time.format.DateTimeFormatter;

public interface FoodDistributor {

    default void summary(Order order) {
        System.out.println("szczegóły:"
                + "\ndata: " + order.getOrderTime().format(DateTimeFormatter.ISO_DATE)
                + ", godzina: " + order.getOrderTime().format(DateTimeFormatter.ISO_TIME)
                + "\ndostawca: " + order.getFoodDistributor()
                + "\ntowar: " + order.getProduct().getProductName()
                + "\nilość: " + order.getQuantity() + "\n");
    }

    void process(Order order);

}
