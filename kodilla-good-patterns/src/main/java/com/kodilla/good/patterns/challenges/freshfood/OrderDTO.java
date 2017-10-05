package com.kodilla.good.patterns.challenges.freshfood;

import java.time.LocalDateTime;

public class OrderDTO {
    private boolean isOrdered;
    private LocalDateTime orderTime;
    private Product product;
    private int quantity;

    public OrderDTO(boolean isOrdered, LocalDateTime orderTime, Product product, int quantity) {
        this.isOrdered = isOrdered;
        this.orderTime = orderTime;
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
