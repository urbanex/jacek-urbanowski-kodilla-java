package com.kodilla.good.patterns.challenges.airline.flight;

import com.kodilla.good.patterns.challenges.airline.Airport;

public class Flight {
    protected final Airport from;
    protected final Airport to;

    public Flight(final Airport from, final Airport to) {
        this.from = from;
        this.to = to;
    }


}
