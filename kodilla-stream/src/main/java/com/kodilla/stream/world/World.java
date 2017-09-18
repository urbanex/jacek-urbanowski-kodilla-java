package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    private final List<Continent> continentList;

    public World(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public BigDecimal getPeopleQuantity(){

        BigDecimal allPeople = continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .collect(Collectors.toSet()).stream()
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return allPeople;
    }

}
