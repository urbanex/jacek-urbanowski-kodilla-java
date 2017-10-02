package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.freshfood.distributors.FoodDistributor;
import com.kodilla.good.patterns.challenges.freshfood.distributors.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.freshfood.distributors.HealthyShop;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrdersSample {
    private ArrayList<FoodDistributor> foodDistributors = new ArrayList<>();
    private ArrayList<Product> productsList = new ArrayList<>();
    private ArrayList<Order> ordersList = new ArrayList<>();

    public ArrayList<Order> retrieve() {

        foodDistributors.add(new ExtraFoodShop());
        foodDistributors.add(new GlutenFreeShop());
        foodDistributors.add(new HealthyShop());

        productsList.add(new Product("Jaja"));
        productsList.add(new Product("Kiełbasa"));
        productsList.add(new Product("Piwo"));

        ordersList.add(new Order(foodDistributors.get(0), productsList.get(0), 200, 10051,
                LocalDateTime.of(2017,10,1,12,22,34)));
        ordersList.add(new Order(foodDistributors.get(1), productsList.get(1), 100, 10052,
                LocalDateTime.of(2017,10,1,12,31,11)));
        ordersList.add(new Order(foodDistributors.get(2), productsList.get(2), 20, 10053,
                LocalDateTime.of(2017,10,1,12,44,44)));

        return new ArrayList<>(ordersList);
    }
}
