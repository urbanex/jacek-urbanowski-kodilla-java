package com.kodilla.good.patterns.challenges.freshfood;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        OrdersSample ordersList = new OrdersSample();
        ArrayList<Order> orders = ordersList.retrieve();

        FoodDistributor extraFoodShop = new ExtraFoodShop();
        FoodDistributor healthyShop = new HealthyShop();
        FoodDistributor glutenFreeShop = new GlutenFreeShop();

        extraFoodShop.process(orders.get(0));
        healthyShop.process(orders.get(1));
        glutenFreeShop.process(orders.get(2));
        glutenFreeShop.process(orders.get(3));

    }

}
