package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;
import com.kodilla.good.patterns.challenges.airline.flight.FlightWithAChange;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AirlineTestSuite {
    private static List<Airport> sampleAirports = new ArrayList<>();
    private static List<DirectFlight> sampleDirectFlights = new ArrayList<>();
    private static FlightsProcessor flightsProcessor;
    private static FlightsData flightsData;
    private static Airport airport1, airport2, airport3, airport4, airport5;
    private static DirectFlight directFlight1, directFlight2, directFlight3, directFlight4, directFlight5, directFlight6, directFlight7, directFlight8, directFlight9, directFlight10, directFlight11;

    private static void generateSampleData() {

        airport1 = new Airport("1", "airport1");
        airport2 = new Airport("2", "airport2");
        airport3 = new Airport("3", "airport3");
        airport4 = new Airport("4", "airport4");
        airport5 = new Airport("5", "airport5");

        ////// SETTING DEPARTURE AIRPORTS = DESTINATION AIRPORTS
        //airport1: flights from: 4, flights to: 4
        airport1.setDepartureAirports(Arrays.asList(airport2, airport3, airport4, airport5));
        //airport2: flights from: 2, flights to: 2
        airport2.setDepartureAirports(Arrays.asList(airport1, airport3));
        //airport3: flights from: 3, flights to: 2
        airport3.setDepartureAirports(Arrays.asList(airport1, airport2, airport4));
        //airport4: flights from: 1, flights to: 2
        airport4.setDepartureAirports(Arrays.asList(airport1));
        //airport5: flights from: 1, flights to: 1
        airport5.setDepartureAirports(Arrays.asList(airport1));

        //all airports list
        sampleAirports = Arrays.asList(airport1, airport2, airport3, airport4, airport5);

        for (Airport airport: sampleAirports) {
            //generate all available flights
            airport.getDepartureAirports()
                    .forEach(destination -> sampleDirectFlights.add(new DirectFlight(airport, destination)));
        }
    }

    @BeforeClass
    public static void beforeClass(){
        //given
        generateSampleData();
        flightsData = mock(FlightsData.class);
        when(flightsData.getAirports()).thenReturn(sampleAirports);
        when(flightsData.getDirectFlights()).thenReturn(sampleDirectFlights);
        flightsProcessor = new FlightsProcessor(flightsData.getAirports(), flightsData.getDirectFlights());
        directFlight1 = new DirectFlight(airport1, airport2);
        directFlight2 = new DirectFlight(airport1, airport3);
        directFlight3 = new DirectFlight(airport1, airport4);
        directFlight4 = new DirectFlight(airport1, airport5);
        directFlight5 = new DirectFlight(airport2, airport1);
        directFlight6 = new DirectFlight(airport2, airport3);
        directFlight7 = new DirectFlight(airport3, airport1);
        directFlight8 = new DirectFlight(airport3, airport2);
        directFlight9 = new DirectFlight(airport3, airport4);
        directFlight10 = new DirectFlight(airport4, airport1);
        directFlight11 = new DirectFlight(airport5, airport1);
    }

    @Test
    public void testGetFlights() {
        //when
        List<DirectFlight> directFlights = flightsProcessor.getDirectFlights();
        //then
        Assert.assertEquals(11, directFlights.size());
    }

    @Test
    public void testGetFlightsFrom() {
        //when
        List<DirectFlight> flightsFromAirport1 = flightsProcessor.getFlightsFrom(sampleAirports.get(0));
        List<DirectFlight> flightsFromAirport2 = flightsProcessor.getFlightsFrom(sampleAirports.get(1));
        List<DirectFlight> flightsFromAirport3 = flightsProcessor.getFlightsFrom(sampleAirports.get(2));
        List<DirectFlight> flightsFromAirport4 = flightsProcessor.getFlightsFrom(sampleAirports.get(3));
        List<DirectFlight> flightsFromAirport5 = flightsProcessor.getFlightsFrom(sampleAirports.get(4));

        //then
        Assert.assertEquals(4, flightsFromAirport1.size());
        Assert.assertEquals(2, flightsFromAirport2.size());
        Assert.assertEquals(3, flightsFromAirport3.size());
        Assert.assertEquals(1, flightsFromAirport4.size());
        Assert.assertEquals(1, flightsFromAirport5.size());

        Assert.assertTrue(flightsFromAirport1.contains(directFlight1)
                && flightsFromAirport1.contains(directFlight2)
                && flightsFromAirport1.contains(directFlight3)
                && flightsFromAirport1.contains(directFlight4));
        Assert.assertTrue(flightsFromAirport2.contains(directFlight5)
                && flightsFromAirport2.contains(directFlight6));
        Assert.assertTrue(flightsFromAirport3.contains(directFlight7)
                && flightsFromAirport3.contains(directFlight8)
                && flightsFromAirport3.contains(directFlight9));
        Assert.assertTrue(flightsFromAirport4.contains(directFlight10));
        Assert.assertTrue(flightsFromAirport5.contains(directFlight11));
    }

    @Test
    public void testGetFlightsTo() {
        //when
        List<DirectFlight> flightsToAirport1 = flightsProcessor.getFlightsTo(sampleAirports.get(0));
        List<DirectFlight> flightsToAirport2 = flightsProcessor.getFlightsTo(sampleAirports.get(1));
        List<DirectFlight> flightsToAirport3 = flightsProcessor.getFlightsTo(sampleAirports.get(2));
        List<DirectFlight> flightsToAirport4 = flightsProcessor.getFlightsTo(sampleAirports.get(3));
        List<DirectFlight> flightsToAirport5 = flightsProcessor.getFlightsTo(sampleAirports.get(4));

        //then
        Assert.assertEquals(4, flightsToAirport1.size());
        Assert.assertEquals(2, flightsToAirport2.size());
        Assert.assertEquals(2, flightsToAirport3.size());
        Assert.assertEquals(2, flightsToAirport4.size());
        Assert.assertEquals(1, flightsToAirport5.size());

        Assert.assertTrue(flightsToAirport1.contains(directFlight5)
                && flightsToAirport1.contains(directFlight7)
                && flightsToAirport1.contains(directFlight10)
                && flightsToAirport1.contains(directFlight11));
        Assert.assertTrue(flightsToAirport2.contains(directFlight1)
                && flightsToAirport2.contains(directFlight8));
        Assert.assertTrue(flightsToAirport3.contains(directFlight2)
                && flightsToAirport3.contains(directFlight6));
        Assert.assertTrue(flightsToAirport4.contains(directFlight3)
                && flightsToAirport4.contains(directFlight9));
        Assert.assertTrue(flightsToAirport5.contains(directFlight4));
    }

    @Test
    public void getFlightsThroughTest() {
        //when
        List<FlightWithAChange> flightsThroughAirport1 = flightsProcessor.getFlightsThrough(sampleAirports.get(0));
        List<FlightWithAChange> flightsThroughAirport2 = flightsProcessor.getFlightsThrough(sampleAirports.get(1));
        List<FlightWithAChange> flightsThroughAirport3 = flightsProcessor.getFlightsThrough(sampleAirports.get(2));
        List<FlightWithAChange> flightsThroughAirport4 = flightsProcessor.getFlightsThrough(sampleAirports.get(3));
        List<FlightWithAChange> flightsThroughAirport5 = flightsProcessor.getFlightsThrough(sampleAirports.get(4));

        //then


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
