package com.kodilla.good.patterns.challenges.airline.flight;

import com.kodilla.good.patterns.challenges.airline.Airport;

public class Flight {
    protected Airport from;
    protected Airport to;

    public Flight(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }
}
