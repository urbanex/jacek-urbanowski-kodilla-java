package com.kodilla.good.patterns.challenges.freshfood;

public class OrderDTO {
    private boolean isOrdered;
    private Product product;
    private int quantity;

    public OrderDTO(boolean isOrdered, Product product, int quantity) {
        this.isOrdered = isOrdered;
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
