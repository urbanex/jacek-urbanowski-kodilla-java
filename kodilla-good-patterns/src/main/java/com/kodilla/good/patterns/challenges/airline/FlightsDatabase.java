package com.kodilla.good.patterns.challenges.airline;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsDatabase {
    private final List<Airport> airports;
    private final List<Flight> flights = new ArrayList<>();

    public FlightsDatabase() {
        Airport ktw = new Airport("Katowice");
        Airport krk = new Airport("Kraków");
        Airport poz = new Airport("Poznań");
        Airport szz = new Airport("Szczecin");
        Airport gdn = new Airport("Gdańsk");
        Airport ieg = new Airport("Zielona Góra");
        Airport waw = new Airport("Warszawa");
        Airport rze = new Airport("Rzeszów");

        ktw.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw, rze})));
        krk.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw, gdn})));
        poz.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw})));
        szz.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw})));
        gdn.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw, krk, rze})));
        ieg.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw})));
        waw.addDestination(new HashSet<>(Arrays.asList(new Airport[] {ktw, krk, poz, szz, gdn, ieg, rze})));
        rze.addDestination(new HashSet<>(Arrays.asList(new Airport[] {waw, ktw, gdn})));

        airports = new ArrayList<>(Arrays.asList(new Airport[] {ktw, krk, poz, szz, gdn, ieg, waw, rze}));

        for (Airport airport: airports) {
            airport.getDepartureTo().stream().
                    forEach(target -> flights.add(new Flight(airport, target)));
        }
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public ArrayList<Flight> getFlightsFrom(Airport airport) {
        List<Flight> flightsFrom = flights.stream().
                filter(flight -> flight.getDepartureAirport().equals(airport)).
                collect(Collectors.toList());

        return new ArrayList<>(flightsFrom);
    }

    public ArrayList<Flight> getFlightsTo(Airport airport) {
        List<Flight> flightsTo = flights.stream().
                filter(flight -> flight.getArrivalAirport().equals(airport)).
                collect(Collectors.toList());

        return new ArrayList<>(flightsTo);
    }

    public void findFlight(Airport airport1, Airport airport2) {
        boolean exists = flights.stream().
                filter(flight -> flight.getDepartureAirport().equals(airport1)).
                filter(flight -> flight.getArrivalAirport().equals(airport2)).
                count() != 0;

        if (exists) {
            System.out.println("Bezpośrednie połączenie jest dostępne.");
        } else {
            System.out.println("Bezpośrednie połączenie niedostępne. Możliwość lotu z przesiądką w: ");

            List<Airport> temp = airports.stream().
                    filter(airport -> airport.equals(airport1) || airport.equals(airport2)).
                    flatMap(airport -> airport.getDepartureTo().stream()).collect(Collectors.toList());

            airports.stream().
                    filter(airport -> airport.equals(airport1) || airport.equals(airport2)).
                    flatMap(airport -> airport.getDepartureTo().stream()).
                    filter(airport -> Collections.frequency(temp, airport) > 1).
                    distinct().
                    forEach(System.out::println);
        }
    }
}
