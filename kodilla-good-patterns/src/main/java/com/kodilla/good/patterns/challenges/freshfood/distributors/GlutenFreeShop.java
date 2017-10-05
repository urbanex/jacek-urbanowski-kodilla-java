package com.kodilla.good.patterns.challenges.freshfood.distributors;

import com.kodilla.good.patterns.challenges.freshfood.Order;
import com.kodilla.good.patterns.challenges.freshfood.OrderDTO;

public class GlutenFreeShop implements FoodDistributor {
    private static final String NAME = "Gluten Free Shop";

    @Override
    public OrderDTO process(Order order) {
        boolean isOrdered = order.getFoodDistributor().getDistributorName().equals(NAME);

        if (isOrdered) {
            System.out.println("Zamówienie numer " + order.getOrderNumber() + " zostało zrealizowane!");
            return new OrderDTO(true, order.getOrderTime(), order.getProduct(), order.getQuantity());
        } else {
            System.out.println("Zamówienie " + order.getOrderNumber() + " nie zostało zrealizowane. Skontaktuj się z glutenfreeshop@gmail.com");
            return new OrderDTO(false, order.getOrderTime(), order.getProduct(), order.getQuantity());
        }
    }

    @Override
    public String getDistributorName() {
        return NAME;
    }
}

