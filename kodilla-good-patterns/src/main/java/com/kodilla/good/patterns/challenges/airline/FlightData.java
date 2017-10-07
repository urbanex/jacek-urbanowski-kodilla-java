package com.kodilla.good.patterns.challenges.airline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FlightData {
    private final List<Airport> airports;
    private final List<Flight> flights;

    public FlightData() {
        Airport gdn = new Airport("Gdańsk");
        Airport ieg = new Airport("Zielona Góra");
        Airport krk = new Airport("Kraków");
        Airport ktw = new Airport("Katowice");
        Airport poz = new Airport("Poznań");
        Airport rze = new Airport("Rzeszów");
        Airport szz = new Airport("Szczecin");
        Airport waw = new Airport("Warszawa");

        gdn.setDepartureAirports(new HashSet<>(Arrays.asList(waw, krk, rze)));
        ieg.setDepartureAirports(new HashSet<>(Arrays.asList(waw)));
        krk.setDepartureAirports(new HashSet<>(Arrays.asList(waw, gdn)));
        ktw.setDepartureAirports(new HashSet<>(Arrays.asList(waw, rze)));
        poz.setDepartureAirports(new HashSet<>(Arrays.asList(waw)));
        rze.setDepartureAirports(new HashSet<>(Arrays.asList(waw, ktw, gdn)));
        szz.setDepartureAirports(new HashSet<>(Arrays.asList(waw)));
        waw.setDepartureAirports(new HashSet<>(Arrays.asList(ktw, krk, poz, szz, gdn, ieg, rze)));

        airports = new ArrayList<>(Arrays.asList(gdn, ieg, krk, ktw, poz, rze, szz, waw));

        flights = new ArrayList<>();
        for (Airport airport: airports) {
            airport.getDepartureAirports().forEach(destination -> flights.add(new Flight(airport, destination)));
        }

        for (Airport airport: airports) {
            airport.setArrivalAirports(flights.stream()
                    .filter(flights -> flights.getArrivalAirport().equals(airport))
                    .map(flight -> flight.getDepartureAirport())
                    .collect(Collectors.toSet()));
        }

    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
