package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.freshfood.distributors.FoodDistributor;
import com.kodilla.good.patterns.challenges.freshfood.distributors.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.freshfood.distributors.HealthyShop;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrdersSample {
    private ArrayList<Order> ordersList = new ArrayList<>();

    public ArrayList<Order> retrieve() {

        FoodDistributor extraFoodShop = new ExtraFoodShop();
        FoodDistributor glutenFreeShop = new GlutenFreeShop();
        FoodDistributor healthyShop = new HealthyShop();

        Product jaja = new Product("Jaja");
        Product kiełbasa = new Product("Kiełbasa");
        Product piwo = new Product("Piwo");

        ordersList.add(new Order(extraFoodShop, 10051,
                LocalDateTime.of(2017,10,1,12,22,34), jaja, 200));
        ordersList.add(new Order(glutenFreeShop, 10052,
                LocalDateTime.of(2017,10,1,12,31,11), kiełbasa, 100));
        ordersList.add(new Order(healthyShop, 10053,
                LocalDateTime.of(2017,10,1,12,44,44), piwo, 20));

        return new ArrayList<>(ordersList);
    }
}
