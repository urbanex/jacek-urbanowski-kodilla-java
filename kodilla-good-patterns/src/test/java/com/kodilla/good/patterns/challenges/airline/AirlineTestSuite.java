package com.kodilla.good.patterns.challenges.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AirlineTestSuite {
    private List<Airport> sampleAirports;
    private List<Flight> sampleFlights;
    private FlightsProcessor flightsProcessor;

    private void generateSampleData() {
        final List<Flight> allFlights = new ArrayList<>();

        Airport airport1 = new Airport("airport1");
        Airport airport2 = new Airport("airport2");
        Airport airport3 = new Airport("airport3");
        Airport airport4 = new Airport("airport4");
        Airport airport5 = new Airport("airport5");

        ////// SETTING DEPARTURE AIRPORTS = DESTINATION AIRPORTS
        //airport1: flights from: 4, flights to: 4
        airport1.setDepartureAirports(new HashSet<>(Arrays.asList(airport2, airport3, airport4, airport5)));
        //airport2: flights from: 2, flights to: 2
        airport2.setDepartureAirports(new HashSet<>(Arrays.asList(airport1, airport3)));
        //airport3: flights from: 3, flights to: 2
        airport3.setDepartureAirports(new HashSet<>(Arrays.asList(airport1, airport2, airport4)));
        //airport4: flights from: 1, flights to: 2
        airport4.setDepartureAirports(new HashSet<>(Arrays.asList(airport1)));
        //airport5: flights from: 1, flights to: 1
        airport5.setDepartureAirports(new HashSet<>(Arrays.asList(airport1)));

        //above airports list
        sampleAirports = new ArrayList<>(Arrays.asList(airport1, airport2, airport3, airport4, airport5));

        //making all flights list
        for (Airport airport: sampleAirports) {
            airport.getDepartureAirports().forEach(target -> allFlights.add(new Flight(airport, target)));
        }

        //SETTING ARRIVAL AIRPORTS = AIRPORTS WHICH HAVE CURRENT AIRPORT IN THEIRS DEPARTURE/DESTINATION AIRPORT SETS
        for (Airport airport: sampleAirports) {
            airport.setArrivalAirports(allFlights.stream()
                    .filter(flights -> flights.getArrivalAirport().equals(airport))
                    .map(flight -> flight.getDepartureAirport())
                    .collect(Collectors.toSet()));
        }

        sampleFlights = allFlights;
    }

    @Before
    public void before(){
        //given
        flightsProcessor = mock(FlightsProcessor.class);
        generateSampleData();

    }

    @Test
    public void testGetFlights() {
        //given
        when(flightsProcessor.getFlights()).thenReturn(sampleFlights);
        //when
        List<Flight> flights = flightsProcessor.getFlights();
        //then
        Assert.assertEquals(11, flights.size());
    }

    @Test
    public void testGetFlightsFrom() {
        //given
        when(flightsProcessor.getFlightsFrom(sampleAirports.get(0))).thenReturn(sampleAirports.get(0).getFlightListTo());
        when(flightsProcessor.getFlightsFrom(sampleAirports.get(1))).thenReturn(sampleAirports.get(1).getFlightListTo());
        when(flightsProcessor.getFlightsFrom(sampleAirports.get(2))).thenReturn(sampleAirports.get(2).getFlightListTo());
        when(flightsProcessor.getFlightsFrom(sampleAirports.get(3))).thenReturn(sampleAirports.get(3).getFlightListTo());
        when(flightsProcessor.getFlightsFrom(sampleAirports.get(4))).thenReturn(sampleAirports.get(4).getFlightListTo());
        //when
        List<Flight> flightsFromAirport1 = flightsProcessor.getFlightsFrom(sampleAirports.get(0));
        List<Flight> flightsFromAirport2 = flightsProcessor.getFlightsFrom(sampleAirports.get(1));
        List<Flight> flightsFromAirport3 = flightsProcessor.getFlightsFrom(sampleAirports.get(2));
        List<Flight> flightsFromAirport4 = flightsProcessor.getFlightsFrom(sampleAirports.get(3));
        List<Flight> flightsFromAirport5 = flightsProcessor.getFlightsFrom(sampleAirports.get(4));
        //then
        Assert.assertEquals(4, flightsFromAirport1.size());
        Assert.assertEquals(2, flightsFromAirport2.size());
        Assert.assertEquals(3, flightsFromAirport3.size());
        Assert.assertEquals(1, flightsFromAirport4.size());
        Assert.assertEquals(1, flightsFromAirport5.size());
    }

    @Test
    public void testGetFlightsTo() {
        //given
        when(flightsProcessor.getFlightsTo(sampleAirports.get(0))).thenReturn(sampleAirports.get(0).getFlightListFrom());
        when(flightsProcessor.getFlightsTo(sampleAirports.get(1))).thenReturn(sampleAirports.get(1).getFlightListFrom());
        when(flightsProcessor.getFlightsTo(sampleAirports.get(2))).thenReturn(sampleAirports.get(2).getFlightListFrom());
        when(flightsProcessor.getFlightsTo(sampleAirports.get(3))).thenReturn(sampleAirports.get(3).getFlightListFrom());
        when(flightsProcessor.getFlightsTo(sampleAirports.get(4))).thenReturn(sampleAirports.get(4).getFlightListFrom());
        //when
        List<Flight> flightsToAirport1 = flightsProcessor.getFlightsTo(sampleAirports.get(0));
        List<Flight> flightsToAirport2 = flightsProcessor.getFlightsTo(sampleAirports.get(1));
        List<Flight> flightsToAirport3 = flightsProcessor.getFlightsTo(sampleAirports.get(2));
        List<Flight> flightsToAirport4 = flightsProcessor.getFlightsTo(sampleAirports.get(3));
        List<Flight> flightsToAirport5 = flightsProcessor.getFlightsTo(sampleAirports.get(4));
        //then
        Assert.assertEquals(4, flightsToAirport1.size());
        Assert.assertEquals(2, flightsToAirport2.size());
        Assert.assertEquals(2, flightsToAirport3.size());
        Assert.assertEquals(2, flightsToAirport4.size());
        Assert.assertEquals(1, flightsToAirport5.size());
    }

    @Ignore
    public void testFindFlight() {
        //given

        /*when(flightsProcessor.findFlight(sampleAirports.get(0),sampleAirports.get(1)))
                .thenReturn();
        *///when

        //then

    }
}
