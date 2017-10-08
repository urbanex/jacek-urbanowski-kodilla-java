package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;
import com.kodilla.good.patterns.challenges.airline.flight.Flight;
import com.kodilla.good.patterns.challenges.airline.flight.FlightWithAChange;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsProcessor {
    private final List<Airport> airports;
    private final List<DirectFlight> directFlights;

    public FlightsProcessor(List<Airport> airports, List<DirectFlight> directFlights) {
        this.airports = airports;
        this.directFlights = directFlights;
    }

    public List<DirectFlight> getDirectFlights() {
        return directFlights;
    }

    public List<DirectFlight> getFlightsFrom(Airport airport) {
        List<DirectFlight> flightsFrom = directFlights.stream()
                .filter(flight -> flight.getFrom().equals(airport))
                .collect(Collectors.toList());

        return new ArrayList<>(flightsFrom);
    }

    public List<DirectFlight> getFlightsTo(Airport airport) {
        List<DirectFlight> flightsTo = directFlights.stream()
                .filter(flight -> flight.getTo().equals(airport))
                .collect(Collectors.toList());

        return new ArrayList<>(flightsTo);
    }

    public List<FlightWithAChange> getFlightsThrough(Airport through) {
        List<FlightWithAChange> flightsThrough = new ArrayList<>();

/*        List<DirectFlight> tempFrom = directFlights.stream()
                .filter(flight -> flight.getTo().equals(through))
                .collect(Collectors.toList());

        List<DirectFlight> tempTo = directFlights.stream()
                .filter(flight -> flight.getFrom().equals(through))
                .collect(Collectors.toList());*/

        List<Airport> tempFrom = directFlights.stream()
                .filter(flight -> flight.getTo().equals(through))
                .map(flight -> flight.getFrom())
                .collect(Collectors.toList());

        List<Airport> tempTo = directFlights.stream()
                .filter(flight -> flight.getFrom().equals(through))
                .map(flight -> flight.getTo())
                .collect(Collectors.toList());


        for (int i = 0; i < tempFrom.size(); i++) {
            for (int j = 0; j < tempTo.size(); j++) {
                if (tempFrom.get(i) != tempTo.get(j)) {

                    flightsThrough.add(new FlightWithAChange(tempFrom.get(i), through, tempTo.get(j)));

                    //flightsThrough.add(new FlightWithAChange(tempFrom.get(i), tempTo.get(j)));
                }
            }
        }

        return new ArrayList<>(flightsThrough);
    }

    public List<Flight> findFlight(Airport from, Airport to) {
        List<Flight> resultFindingFlights;
        boolean exists = directFlights.stream()
                .filter(flight -> flight.getFrom().equals(from))
                .filter(flight -> flight.getTo().equals(to))
                .count() != 0;

        if (exists) {
            resultFindingFlights = new ArrayList<>(directFlights.stream()
                    .filter(flight -> flight.getFrom().equals(from))
                    .filter(flight -> flight.getTo().equals(to))
                    .collect(Collectors.toList()));
        } else {
            resultFindingFlights = new ArrayList<>();

            List<Airport> temp = airports.stream()
                    .filter(airport -> airport.equals(from) || airport.equals(to))
                    .flatMap(airport -> airport.getDepartureAirports().stream())
                    .collect(Collectors.toList());

            List<Airport> throughAirports = airports.stream()
                    .filter(airport -> airport.equals(from) || airport.equals(to))
                    .flatMap(airport -> airport.getDepartureAirports().stream())
                    .filter(airport -> Collections.frequency(temp, airport) > 1)
                    .distinct()
                    .collect(Collectors.toList());

            for (Airport airport: throughAirports) {
                //DirectFlight directFlight1 = directFlights.get(directFlights.indexOf(new DirectFlight(from, airport)));
                //DirectFlight directFlight2 = directFlights.get(directFlights.indexOf(new DirectFlight(airport, to)));
                //FlightWithAChange flyThrough = getFlightsThrough(airport).get(getFlightsThrough(airport).indexOf(new FlightWithAChange(directFlight1, directFlight2)));

                FlightWithAChange flyThrough = getFlightsThrough(airport).get(getFlightsThrough(airport).indexOf(new FlightWithAChange(from, airport ,to)));
                resultFindingFlights.add(flyThrough);
            }
        }

        return new ArrayList<>(resultFindingFlights);
    }

    public void flight(Airport airport) {
        System.out.println(airport.getDirectFlightToList());
    }

}
