package com.kodilla.good.patterns.challenges.freshfood;

public class ExtraFoodShop implements FoodDistributor {
    @Override
    public void process(Order order) {
        summary(order);
        System.out.println("Dziękujemy za zakupy w ExtraFoodShop!\n");
    }

}
