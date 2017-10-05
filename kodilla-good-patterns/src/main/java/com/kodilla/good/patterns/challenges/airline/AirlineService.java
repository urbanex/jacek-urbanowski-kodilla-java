package com.kodilla.good.patterns.challenges.airline;

import java.util.List;

public class AirlineService {
    public static void main(String[] args) {
        FlightsDatabase database = new FlightsDatabase();
        List<Flight> flights = database.getFlights();

        System.out.println("Wszystkie loty w systemie: ");
        for (Flight flight: flights) {
            System.out.println(flight);
        }

        System.out.println();

        List<Flight> flightsFrom = database.getFlightsFrom(new Airport("Warszawa"));
                System.out.println("Wszystkie loty z Warszawy: ");
        for (Flight flight: flightsFrom) {
            System.out.println(flight);
        }

        System.out.println();

        List<Flight> flightsTo = database.getFlightsTo(new Airport("Gdańsk"));
        System.out.println("Wszystkie loty do Gdańska: ");
        for (Flight flight: flightsTo) {
            System.out.println(flight);
        }

        System.out.println();

        System.out.println("Wyszukiwarka połączeń:");
        System.out.print("Połączenie Warszawa - Kraków: ");
        database.findFlight(new Airport("Warszawa"), new Airport("Kraków"));

        System.out.println();

        System.out.print("Połączenie Kraków - Poznań: ");
        database.findFlight(new Airport("Kraków"), new Airport("Poznań"));

        System.out.println();

        System.out.print("Połączenie Katowice - Gdańsk: ");
        database.findFlight(new Airport("Katowice"), new Airport("Gdańsk"));
    }
}
