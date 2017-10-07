package com.kodilla.good.patterns.challenges.airline;

import java.util.List;

public class AirlineService {
    public static void main(String[] args) {
        FlightData flightData = new FlightData();
        FlightsProcessor flightProcessor = new FlightsProcessor(flightData.getAirports(), flightData.getFlights());
        List<Flight> flights = flightProcessor.getFlights();

        System.out.println("Wszystkie loty w systemie: ");
        for (Flight flight: flights) {
            System.out.println(flight);
        }

        System.out.println();

        List<Flight> flightsFrom = flightProcessor.getFlightsFrom(new Airport("Warszawa"));
                System.out.println("Wszystkie loty z Warszawy: ");
        for (Flight flight: flightsFrom) {
            System.out.println(flight);
        }

        System.out.println();

        List<Flight> flightsTo = flightProcessor.getFlightsTo(new Airport("Gdańsk"));
        System.out.println("Wszystkie loty do Gdańska: ");
        for (Flight flight: flightsTo) {
            System.out.println(flight);
        }

        System.out.println();

        System.out.println("Wyszukiwarka połączeń:");
        System.out.print("Połączenie Warszawa - Kraków: ");
        flightProcessor.findFlight(new Airport("Warszawa"), new Airport("Kraków"));

        System.out.println();

        System.out.print("Połączenie Kraków - Poznań: ");
        flightProcessor.findFlight(new Airport("Kraków"), new Airport("Poznań"));

        System.out.println();

        System.out.print("Połączenie Katowice - Gdańsk: ");
        flightProcessor.findFlight(new Airport("Katowice"), new Airport("Gdańsk"));

        flightProcessor.flight(flightData.getAirports().get(7));

    }
}
