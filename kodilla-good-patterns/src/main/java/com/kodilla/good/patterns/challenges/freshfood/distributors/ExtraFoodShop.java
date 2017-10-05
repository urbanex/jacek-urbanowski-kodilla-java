package com.kodilla.good.patterns.challenges.freshfood.distributors;

import com.kodilla.good.patterns.challenges.freshfood.Order;
import com.kodilla.good.patterns.challenges.freshfood.OrderDTO;

public class ExtraFoodShop implements FoodDistributor {
    private static final String NAME = "Extra Food Shop";

    @Override
    public OrderDTO process(Order order) {
        boolean isOrdered = order.getFoodDistributor().getDistributorName().equals(NAME);

        if (isOrdered) {
            System.out.println("Zamówienie numer " + order.getOrderNumber() + " zostało zrealizowane!");
            return new OrderDTO(true, order.getOrderTime(), order.getProduct(), order.getQuantity());
        } else {
            System.out.println("Zamówienie " + order.getOrderNumber() + " nie zostało zrealizowane. Skontaktuj się z extra@food.shop");
            return new OrderDTO(false, order.getOrderTime(), order.getProduct(), order.getQuantity());
        }
    }

    @Override
    public String getDistributorName() {
        return NAME;
    }
}
