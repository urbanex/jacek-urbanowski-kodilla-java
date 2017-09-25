package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightRunner {

    public boolean findFlght(Flight flight) throws RouteNotFoundException {
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

        if (map.containsKey(flight.getArrivalAirport()) && map.containsKey(flight.getDepartureAirport())) {
            return map.get(flight.getArrivalAirport()) && map.get(flight.getDepartureAirport());
        } else {

            if (map.containsKey(flight.getDepartureAirport())) {
                message += flight.getArrivalAirport();
            } else message += flight.getDepartureAirport();

            throw new RouteNotFoundException(message);
        }
    }

    public static void main(String[] args) {
        Flight flight1 = new Flight("Warsaw", "Prague");
        Flight flight2 = new Flight("Warsaw", "Paris");
        Flight flight3 = new Flight("Warsaw", "Machu Picchu");
        FlightRunner flightRunner = new FlightRunner();

        System.out.println("Flights availability:");

        try {
            System.out.print("Warsaw - Prague: ");
            System.out.println(flightRunner.findFlght(flight1));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Warsaw - Paris: ");
            System.out.println(flightRunner.findFlght(flight2));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Warsaw - Machu Picchu: ");
            System.out.println(flightRunner.findFlght(flight3));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
