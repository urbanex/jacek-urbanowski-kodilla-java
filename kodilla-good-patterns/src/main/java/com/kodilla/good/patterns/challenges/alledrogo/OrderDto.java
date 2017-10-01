package com.kodilla.good.patterns.challenges.alledrogo;

public class OrderDto {
    private User user;
    private Product product;
    private boolean isBought;

    public OrderDto(final User user, final Product product, final boolean isBought) {
        this.user = user;
        this.product = product;
        this.isBought = isBought;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isBought() {
        return isBought;
    }
}
