package com.kodilla.good.patterns.challenges.freshfood;

import com.kodilla.good.patterns.challenges.freshfood.distributors.FoodDistributor;

import java.time.LocalDateTime;

public class Order {
    private FoodDistributor foodDistributor;
    private Product product;
    private int quantity;
    private int orderNumber;
    private LocalDateTime orderTime;

    public Order(final FoodDistributor foodDistributor,
                 final int orderNumber,
                 final LocalDateTime orderTime,
                 final Product product,
                 final int quantity) {
        this.foodDistributor = foodDistributor;
        this.product = product;
        this.quantity = quantity;
        this.orderNumber = orderNumber;
        this.orderTime = orderTime;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}
