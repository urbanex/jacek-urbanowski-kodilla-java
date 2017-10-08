package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private final String airportIndicator;
    private final String value;
    private List<Airport> departureAirports;
    private List<Airport> arrivalAirports;
    private List<DirectFlight> directFlightToList;
    private List<DirectFlight> directFlightFromList;

    public Airport(final String airportIndicator, final String value) {
        this.airportIndicator = airportIndicator;
        this.value = value;
    }

    public void setDepartureAirports(List airports) {
        departureAirports = new ArrayList<Airport>(airports);
    }

    public void setArrivalAirports(List airports) {
        arrivalAirports = new ArrayList<Airport>(airports);
    }

    public void setDirectFlightToList(List<DirectFlight> directFlightToList) {
        this.directFlightToList = directFlightToList;
    }

    public void setDirectFlightFromList(List<DirectFlight> directFlightFromList) {
        this.directFlightFromList = directFlightFromList;
    }

    public String getValue() {
        return value;
    }

    public String getAirportIndicator() {
        return airportIndicator;
    }

    public List<Airport> getDepartureAirports() {
        return departureAirports;
    }

    public List<DirectFlight> getDirectFlightToList() {
        return directFlightToList;
    }

    public List<Airport> getArrivalAirports() {
        return arrivalAirports;
    }

    public List<DirectFlight> getDirectFlightFromList() {
        return directFlightFromList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!airportIndicator.equals(airport.airportIndicator)) return false;
        return value.equals(airport.value);
    }

    @Override
    public int hashCode() {
        int result = airportIndicator.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
