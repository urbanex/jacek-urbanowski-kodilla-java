package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightRunner {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String message = "there is no airport in ";
        Map<String, Boolean> map = new HashMap<>();
        map.put("Bratislava", true);
        map.put("Budapest", true);
        map.put("Warsaw", true);
        map.put("Prague", true);
        map.put("Vienna", false);
        map.put("Berlin", false);
        map.put("Moscow", false);
        map.put("Rome", false);
        map.put("Oslo", false);
        map.put("Stockholm", false);
        map.put("Copenhagen", false);
        map.put("Paris", false);
        map.put("Madrid", false);
        map.put("Lisbon", false);

        boolean mapContainsArrivalAirport = map.containsKey(flight.getArrivalAirport());
        boolean mapContainsDepartureAirport = map.containsKey(flight.getDepartureAirport());

        String arrivalAirport = flight.getArrivalAirport();
        String departureAirport = flight.getDepartureAirport();

        if (mapContainsArrivalAirport && mapContainsDepartureAirport) {
            return map.get(arrivalAirport) && map.get(departureAirport);
        } else {
            if (!mapContainsArrivalAirport && !mapContainsDepartureAirport) {
                message = "there are no airports in " + departureAirport + " and " + arrivalAirport;
            } else if (!mapContainsArrivalAirport) {
                message += arrivalAirport;
            } else {
                message += departureAirport;
            }
            throw new RouteNotFoundException(message);
        }
    }

    public static void main(String[] args) {
        Flight flight1 = new Flight("Warsaw", "Prague");
        Flight flight2 = new Flight("Warsaw", "Paris");
        Flight flight3 = new Flight("Warsaw", "Machu Picchu");
        Flight flight4 = new Flight("Szczebrzeszyn", "Warsaw");
        Flight flight5 = new Flight("Szczebrzeszyn", "Machu Picchu");
        FlightRunner flightRunner = new FlightRunner();

        System.out.println("Flights availability:");

        try {
            System.out.print("Warsaw - Prague: ");
            System.out.println(flightRunner.findFlight(flight1));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Warsaw - Paris: ");
            System.out.println(flightRunner.findFlight(flight2));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Warsaw - Machu Picchu: ");
            System.out.println(flightRunner.findFlight(flight3));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Szczebrzeszyn - Warsaw: ");
            System.out.println(flightRunner.findFlight(flight4));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Szczebrzeszyn - Machu Picchu: ");
            System.out.println(flightRunner.findFlight(flight5));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
