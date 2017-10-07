package com.kodilla.good.patterns.challenges.airline;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsProcessor {
    private final List<Airport> airports;
    private final List<Flight> flights;

    public FlightsProcessor(List<Airport> airports, List<Flight> flights) {
        this.airports = airports;
        this.flights = flights;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Flight> getFlightsFrom(Airport airport) {
        List<Flight> flightsFrom = flights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .collect(Collectors.toList());

        return new ArrayList<>(flightsFrom);
    }

    public List<Flight> getFlightsTo(Airport airport) {
        List<Flight> flightsTo = flights.stream()
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .collect(Collectors.toList());

        return new ArrayList<>(flightsTo);
    }

    public void findFlight(Airport from, Airport to) {
        boolean exists = flights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(from))
                .filter(flight -> flight.getArrivalAirport().equals(to))
                .count() != 0;

        if (exists) {
            System.out.println("Bezpośrednie połączenie jest dostępne.");
        } else {
            System.out.println("Bezpośrednie połączenie niedostępne. Możliwość lotu z przesiądką w: ");

            List<Airport> temp = airports.stream()
                    .filter(airport -> airport.equals(from) || airport.equals(to))
                    .flatMap(airport -> airport.getDepartureAirports().stream())
                    .collect(Collectors.toList());

            airports.stream()
                    .filter(airport -> airport.equals(from) || airport.equals(to))
                    .flatMap(airport -> airport.getDepartureAirports().stream())
                    .filter(airport -> Collections.frequency(temp, airport) > 1)
                    .distinct()
                    .forEach(System.out::println);
        }
    }

    public void flight(Airport airport) {
        System.out.println(airport.getFlightListTo());
    }

}
