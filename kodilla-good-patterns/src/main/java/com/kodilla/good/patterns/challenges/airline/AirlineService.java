package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;
import com.kodilla.good.patterns.challenges.airline.flight.Flight;
import com.kodilla.good.patterns.challenges.airline.flight.FlightWithAChange;

import java.util.List;

public class AirlineService {
    public static void main(String[] args) {
        FlightsData flightsData = new FlightsData();
        FlightsProcessor flightProcessor = new FlightsProcessor(flightsData.getAirports(), flightsData.getDirectFlights());
        List<DirectFlight> directFlights = flightProcessor.getDirectFlights();

        System.out.println("All available direct flights: ");
        for (DirectFlight directFlight : directFlights) {
            System.out.println(directFlight);
        }

        System.out.println();

        List<DirectFlight> flightsFrom = flightProcessor.getFlightsFrom(new Airport("WAW","Warszawa"));
                System.out.println("All flights from WAW: ");
        for (DirectFlight directFlight : flightsFrom) {
            System.out.println(directFlight);
        }

        System.out.println();

        List<DirectFlight> flightsTo = flightProcessor.getFlightsTo(new Airport("GDN", "Gdańsk"));
        System.out.println("All flights to GDN: ");
        for (DirectFlight directFlight : flightsTo) {
            System.out.println(directFlight);
        }

        System.out.println();

        System.out.println("All flights with change in WAW: ");
        for (FlightWithAChange flightWithAChange: flightProcessor.getFlightsThrough(new Airport("WAW", "Warszawa"))) {
            System.out.println(flightWithAChange);
        }

        System.out.println();

        System.out.println("CONNECTION FINDER:");
        System.out.println("WAW - KRA");
        for (Flight flight: flightProcessor.findFlight(new Airport("WAW", "Warszawa"), new Airport("KRK", "Kraków"))) {
            System.out.println(flight);
        }

        System.out.println();

        System.out.println("KRA - POZ");
        for (Flight flight: flightProcessor.findFlight(new Airport("KRK","Kraków"), new Airport("POZ", "Poznań"))) {
            System.out.println(flight);
        }

        System.out.println();

        System.out.println("KTW - GDN");
        for (Flight flight: flightProcessor.findFlight(new Airport("KTW", "Katowice"), new Airport("GDN", "Gdańsk"))) {
            System.out.println(flight);
        }

        System.out.println();

    }
}
