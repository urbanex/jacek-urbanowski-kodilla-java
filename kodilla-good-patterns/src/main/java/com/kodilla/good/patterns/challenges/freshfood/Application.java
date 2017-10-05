package com.kodilla.good.patterns.challenges.freshfood;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        OrdersSample ordersList = new OrdersSample();
        ArrayList<Order> orders = ordersList.retrieve();

        for (Order order: orders) {
            OrderDTO orderDTO = order.getFoodDistributor().process(order);
            if (orderDTO.isOrdered()) {
                System.out.println("szczegóły:"
                        + "\ntowar: " + orderDTO.getProduct().getProductName()
                        + "\nilość: " + orderDTO.getQuantity() + "\n");
            }
        }
    }
}
