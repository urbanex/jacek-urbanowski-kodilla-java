package com.kodilla.good.patterns.challenges.freshfood;

public class Order {
    private Provider provider;
    private Product product;
    private double quantity;
    private Customer customer;

    public Order(final Provider provider, final Product product, final double quantity, final Customer customer) {
        this.provider = provider;
        this.product = product;
        this.quantity = quantity;
        this.customer = customer;
    }

    public Provider getProvider() {
        return provider;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public Customer getCustomer() {
        return customer;
    }
}
