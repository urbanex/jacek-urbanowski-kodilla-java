package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsData {
    private final List<Airport> airports;
    private final List<DirectFlight> directFlights;

    public FlightsData() {
        airports = generateAllAirportsWithTheirsDepartureAirports();
        directFlights = generateAllAvailableDirectFlights(airports);
        setAllDirectFlightsNumbersAndIndicators(directFlights);
        setArrivalAirports(airports, directFlights);
        setFlightToLists(airports, directFlights);
        setFlightFromLists(airports, directFlights);
    }

    private List<Airport> generateAllAirportsWithTheirsDepartureAirports(){
        Airport gdn = new Airport("GDN", "Gdańsk");
        Airport ieg = new Airport("IEG", "Zielona Góra");
        Airport krk = new Airport("KRK", "Kraków");
        Airport ktw = new Airport("KTW", "Katowice");
        Airport poz = new Airport("POZ", "Poznań");
        Airport rze = new Airport("RZE", "Rzeszów");
        Airport szz = new Airport("SZZ", "Szczecin");
        Airport waw = new Airport("WAW", "Warszawa");

        waw.setDepartureAirports(Arrays.asList(ktw, krk, poz, szz, gdn, ieg, rze));
        gdn.setDepartureAirports(Arrays.asList(waw, krk, rze));
        ktw.setDepartureAirports(Arrays.asList(waw, rze));
        krk.setDepartureAirports(Arrays.asList(waw, gdn));
        poz.setDepartureAirports(Arrays.asList(waw));
        rze.setDepartureAirports(Arrays.asList(waw, ktw, gdn));
        szz.setDepartureAirports(Arrays.asList(waw));
        ieg.setDepartureAirports(Arrays.asList(waw));

        return new ArrayList<>(Arrays.asList(waw, gdn, ktw, krk, poz, rze, szz, ieg));
    }

    private List<DirectFlight> generateAllAvailableDirectFlights(List<Airport> airports){
        List<DirectFlight> result = new ArrayList<>();
        for (Airport airport: airports) {
            airport.getDepartureAirports()
                    .forEach(destination -> result.add(new DirectFlight(airport, destination)));
        }
        return new ArrayList<>(result);
    }

    private void setAllDirectFlightsNumbersAndIndicators(List<DirectFlight> directFlights){
        int counter = 1;
        for (DirectFlight directFlight : directFlights) {
            directFlight.setNumber(counter++);
            directFlight.setFlightIndicator(directFlight.getFrom().getAirportIndicator()
                    + " - " + directFlight.getTo().getAirportIndicator());
        }
    }

    private void setArrivalAirports(List<Airport> airports, List<DirectFlight> directFlights) {
        for (Airport airport : airports) {
            airport.setArrivalAirports(directFlights.stream()
                    .filter(flights -> flights.getTo().equals(airport))
                    .map(flight -> flight.getFrom())
                    .collect(Collectors.toList()));
        }
    }

    private void setFlightToLists(List<Airport> airports, List<DirectFlight> directFlights){
        for (Airport airport: airports) {
            airport.setDirectFlightToList(directFlights.stream()
                    .filter(flight -> flight.getFrom().equals(airport))
                    .collect(Collectors.toList()));
        }
    }

    private void setFlightFromLists(List<Airport> airports, List<DirectFlight> directFlights){
        for (Airport airport: airports) {
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
