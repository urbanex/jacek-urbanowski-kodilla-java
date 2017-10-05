package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.FoodDistributor;

import java.time.LocalDateTime;

public class Order {
    private int orderNumber;
    private LocalDateTime orderTime;
    private FoodDistributor foodDistributor;
    private Product product;
    private int quantity;

    public Order(final int orderNumber,
                 final LocalDateTime orderTime,
                 final FoodDistributor foodDistributor,
                 final Product product,
                 final int quantity) {
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
        this.foodDistributor = foodDistributor;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public FoodDistributor getFoodDistributor() {
        return foodDistributor;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
