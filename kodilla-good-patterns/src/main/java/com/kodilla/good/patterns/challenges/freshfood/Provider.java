package com.kodilla.good.patterns.challenges.freshfood;

public class Provider {
    private String name;
    private String adress;

    public Provider(final String name, final String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

}
