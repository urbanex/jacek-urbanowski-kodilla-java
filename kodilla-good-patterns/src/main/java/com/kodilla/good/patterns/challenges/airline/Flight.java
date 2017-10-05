package com.kodilla.good.patterns.challenges.airline;

public class Flight {
    private final Airport departureAirport;
    private final Airport arrivalAirport;

    public Flight(final Airport departureAirport, final Airport arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public String toString() {
        return "Flight {" +
                "from: " + departureAirport.getValue() +
                ", to: " + arrivalAirport.getValue() +
                '}';
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
}