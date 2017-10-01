package com.kodilla.good.patterns.challenges.alledrogo;

import java.util.ArrayList;

public class User {
    private final String nickname;
    private final String firstName;
    private final String lastName;
    private ArrayList<Order> historyOfOrders = new ArrayList<>();

    public User(final String nickname, final String firstName, final String lastName) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void addOrderToUserHistory(Order order) {
        historyOfOrders.add(order);
    }
}
