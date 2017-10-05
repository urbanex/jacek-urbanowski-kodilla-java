package com.kodilla.good.patterns.challenges.airline;

import java.util.HashSet;
import java.util.Set;

public class Airport {
    private final String value;
    private Set<Airport> departureTo;

    public Airport(final String value) {
        this.value = value;
    }

    public void addDestination(Set airports) {
        departureTo = new HashSet<Airport>(airports);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return value != null ? value.equals(airport.value) : airport.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public String getValue() {
        return value;
    }

    public Set<Airport> getDepartureTo() {
        return departureTo;
    }

    @Override
    public String toString() {
        return value;
    }
}
