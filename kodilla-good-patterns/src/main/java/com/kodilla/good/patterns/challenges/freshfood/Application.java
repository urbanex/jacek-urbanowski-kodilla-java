package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.HealthyShop;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        OrdersSample ordersList = new OrdersSample();
        ArrayList<Order> orders = ordersList.retrieve();
        Order order1 = orders.get(0);
        Order order2 = orders.get(1);
        Order order3 = orders.get(2);

        order1.getFoodDistributor().process(order1);
        order2.getFoodDistributor().process(order2);

        //to ponizej to tak specjalnie: by zobaczyc niezrealizowane zamówienie
        new HealthyShop().process(order3);

    }
}