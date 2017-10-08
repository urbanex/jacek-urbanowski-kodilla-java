package com.kodilla.good.patterns.challenges.airline.flight;

import com.kodilla.good.patterns.challenges.airline.Airport;

public class DirectFlight extends Flight {
    private int number;
    private String flightIndicator;

    public DirectFlight(final Airport from, final Airport to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return "Flight " + number +
                ": " + flightIndicator +
                " (" + from +
                " - " + to +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectFlight that = (DirectFlight) o;

        if (!from.equals(that.from)) return false;
        return to.equals(that.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFlightIndicator(String flightIndicator) {
        this.flightIndicator = flightIndicator;
    }

    public int getNumber() {
        return number;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }
}