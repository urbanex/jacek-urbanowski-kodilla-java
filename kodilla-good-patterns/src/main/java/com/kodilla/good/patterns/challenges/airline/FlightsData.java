package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsData {
    private final List<Airport> airports;
    private final List<DirectFlight> directFlights;
    private int counter = 1;

    public FlightsData() {
        Airport gdn = new Airport("GDN", "Gdańsk");
        Airport ieg = new Airport("IEG", "Zielona Góra");
        Airport krk = new Airport("KRK", "Kraków");
        Airport ktw = new Airport("KTW", "Katowice");
        Airport poz = new Airport("POZ", "Poznań");
        Airport rze = new Airport("RZE", "Rzeszów");
        Airport szz = new Airport("SZZ", "Szczecin");
        Airport waw = new Airport("WAW", "Warszawa");

        //set departure airports for each airport
        waw.setDepartureAirports(Arrays.asList(ktw, krk, poz, szz, gdn, ieg, rze));
        gdn.setDepartureAirports(Arrays.asList(waw, krk, rze));
        ieg.setDepartureAirports(Arrays.asList(waw));
        krk.setDepartureAirports(Arrays.asList(waw, gdn));
        ktw.setDepartureAirports(Arrays.asList(waw, rze));
        poz.setDepartureAirports(Arrays.asList(waw));
        rze.setDepartureAirports(Arrays.asList(waw, ktw, gdn));
        szz.setDepartureAirports(Arrays.asList(waw));

        airports = Arrays.asList(gdn, ieg, krk, ktw, poz, rze, szz, waw);
        directFlights = new ArrayList<>();

        for (Airport airport: airports) {
            //generate all available directFlights
            airport.getDepartureAirports()
                    .forEach(destination -> directFlights.add(new DirectFlight(airport, destination)));

            //set flightToList for each airport
            airport.setDirectFlightToList(directFlights.stream()
                    .filter(flight -> flight.getFrom().equals(airport))
                    .collect(Collectors.toList()));
        }

        //set all directFlights numbers and indicators
        for (DirectFlight directFlight : directFlights) {
            directFlight.setNumber(counter++);
            directFlight.setFlightIndicator(directFlight.getFrom().getAirportIndicator() + " - " + directFlight.getTo().getAirportIndicator());
        }

        for (Airport airport: airports) {
            //set arrival airports for each airport
            airport.setArrivalAirports(directFlights.stream()
                    .filter(flights -> flights.getTo().equals(airport))
                    .map(flight -> flight.getFrom())
                    .collect(Collectors.toList()));

            //set flightFromList for each airport
            airport.setDirectFlightFromList(directFlights.stream()
                    .filter(flight -> flight.getTo().equals(airport))
                    .collect(Collectors.toList()));
        }
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<DirectFlight> getDirectFlights() {
        return directFlights;
    }
}
