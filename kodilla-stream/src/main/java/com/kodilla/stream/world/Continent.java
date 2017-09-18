package com.kodilla.stream.world;

import java.util.List;

public final class Continent {
    private final List<Country> countryList;

    public Continent(final List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
