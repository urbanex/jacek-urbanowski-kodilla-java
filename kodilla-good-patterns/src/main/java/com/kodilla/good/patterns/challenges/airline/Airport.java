package com.kodilla.good.patterns.challenges.airline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {
    private final String value;
    private Set<Airport> departureAirports;
    private Set<Airport> arrivalAirports;
    private List<Flight> flightListTo = new ArrayList<>();
    private List<Flight> flightListFrom = new ArrayList<>();

    public Airport(final String value) {
        this.value = value;
    }

    public void setDepartureAirports(Set airports) {
        departureAirports = new HashSet<Airport>(airports);
    }

    public void setArrivalAirports(Set airports) {
        arrivalAirports = new HashSet<Airport>(airports);
    }


    public List<Flight> getFlightListTo() {
        for (Airport airport: departureAirports) {
            flightListTo.add(new Flight(this, airport));
        }
        return flightListTo;
    }

    public List<Flight> getFlightListFrom() {
        for (Airport airport: arrivalAirports) {
            flightListFrom.add(new Flight(airport, this));
        }
        return flightListFrom;
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

    public Set<Airport> getDepartureAirports() {
        return departureAirports;
    }

    @Override
    public String toString() {
        return value;
    }
}
