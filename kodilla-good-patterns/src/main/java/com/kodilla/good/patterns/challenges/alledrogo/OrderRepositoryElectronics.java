package com.kodilla.good.patterns.challenges.alledrogo;

import java.util.ArrayList;

public class OrderRepositoryElectronics implements OrderRepository {
    private static ArrayList<Order> orderRepository = new ArrayList<>();

    @Override
    public void addOrderToRepository(Order order) {
        orderRepository.add(order);
        System.out.println("REPOSITORY SERVICE:\nthe order has been added to electronics category\n");
    }
}
