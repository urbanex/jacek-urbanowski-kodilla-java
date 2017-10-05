package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrdersSample {
    private ArrayList<Order> ordersList = new ArrayList<>();

    public ArrayList<Order> retrieve() {

        FoodDistributor extraFoodShop = new ExtraFoodShop();
        FoodDistributor glutenFreeShop = new GlutenFreeShop();
        FoodDistributor healthyShop = new HealthyShop();

        Product eggs = new Product("Jaja");
        Product sausages = new Product("Kiełbasa");
        Product beer = new Product("Piwo");

        ordersList.add(new Order(10051, LocalDateTime.of(2017,10,1,12,22,34),
                extraFoodShop, eggs, 200));
        ordersList.add(new Order(10052, LocalDateTime.of(2017,10,1,12,31,11),
                glutenFreeShop, sausages, 100));
        ordersList.add(new Order(10053, LocalDateTime.of(2017,10,1,12,44,44),
                healthyShop, beer, 20));
        ordersList.add(new Order(10054, LocalDateTime.of(2017,10,2,21,11,11),
                extraFoodShop, beer, 50));
        ordersList.add(new Order(10055, LocalDateTime.of(2017,10,3,14,15,56),
                glutenFreeShop, eggs, 40));
        ordersList.add(new Order(10056, LocalDateTime.of(2017,10,4,9,39,41),
                healthyShop, sausages, 80));

        return new ArrayList<>(ordersList);
    }
}
