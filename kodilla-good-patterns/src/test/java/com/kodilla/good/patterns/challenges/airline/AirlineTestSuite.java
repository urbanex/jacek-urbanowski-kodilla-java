package com.kodilla.good.patterns.challenges.airline;

import com.kodilla.good.patterns.challenges.airline.flight.DirectFlight;
import com.kodilla.good.patterns.challenges.airline.flight.Flight;
import com.kodilla.good.patterns.challenges.airline.flight.FlightWithAChange;
import org.junit.Assert;
import org.junit.BeforeClass;
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
    private static DirectFlight directFlight1, directFlight2, directFlight3, directFlight4, directFlight5,
            directFlight6, directFlight7, directFlight8, directFlight9, directFlight10, directFlight11;

    private static void generateSampleData() {

        airport1 = new Airport("1", "airport1");
        airport2 = new Airport("2", "airport2");
        airport3 = new Airport("3", "airport3");
        airport4 = new Airport("4", "airport4");
        airport5 = new Airport("5", "airport5");

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

        Assert.assertTrue(flightsFromAirport1.containsAll(Arrays.asList(directFlight1, directFlight2, directFlight3, directFlight4)));
        Assert.assertTrue(flightsFromAirport2.containsAll(Arrays.asList(directFlight5, directFlight6)));
        Assert.assertTrue(flightsFromAirport3.containsAll(Arrays.asList(directFlight7, directFlight8, directFlight9)));
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

        Assert.assertTrue(flightsToAirport1.containsAll(Arrays.asList(directFlight5, directFlight7, directFlight10, directFlight11)));
        Assert.assertTrue(flightsToAirport2.containsAll(Arrays.asList(directFlight1, directFlight8)));
        Assert.assertTrue(flightsToAirport3.containsAll(Arrays.asList(directFlight2, directFlight6)));
        Assert.assertTrue(flightsToAirport4.containsAll(Arrays.asList(directFlight3, directFlight9)));
        Assert.assertTrue(flightsToAirport5.contains(directFlight4));
    }

    @Test
    public void testGetFlightsThrough() {
        //given
        //through airport1
        FlightWithAChange flight213 = new FlightWithAChange(airport2, airport1, airport3);
        FlightWithAChange flight214 = new FlightWithAChange(airport2, airport1, airport4);
        FlightWithAChange flight215 = new FlightWithAChange(airport2, airport1, airport5);
        FlightWithAChange flight312 = new FlightWithAChange(airport3, airport1, airport2);
        FlightWithAChange flight314 = new FlightWithAChange(airport3, airport1, airport4);
        FlightWithAChange flight315 = new FlightWithAChange(airport3, airport1, airport5);
        FlightWithAChange flight412 = new FlightWithAChange(airport4, airport1, airport2);
        FlightWithAChange flight413 = new FlightWithAChange(airport4, airport1, airport3);
        FlightWithAChange flight415 = new FlightWithAChange(airport4, airport1, airport5);
        FlightWithAChange flight512 = new FlightWithAChange(airport5, airport1, airport2);
        FlightWithAChange flight513 = new FlightWithAChange(airport5, airport1, airport3);
        FlightWithAChange flight514 = new FlightWithAChange(airport5, airport1, airport4);
        //through airport2
        FlightWithAChange flight123 = new FlightWithAChange(airport1, airport2, airport3);
        FlightWithAChange flight321 = new FlightWithAChange(airport3, airport2, airport1);
        //through airport3
        FlightWithAChange flight132 = new FlightWithAChange(airport1, airport3, airport2);
        FlightWithAChange flight134 = new FlightWithAChange(airport1, airport3, airport4);
        FlightWithAChange flight231 = new FlightWithAChange(airport2, airport3, airport1);
        FlightWithAChange flight234 = new FlightWithAChange(airport2, airport3, airport4);
        //through airport4
        FlightWithAChange flight341 = new FlightWithAChange(airport3, airport4, airport1);

        //when
        List<FlightWithAChange> flightsThroughAirport1 = flightsProcessor.getFlightsThrough(sampleAirports.get(0));
        List<FlightWithAChange> flightsThroughAirport2 = flightsProcessor.getFlightsThrough(sampleAirports.get(1));
        List<FlightWithAChange> flightsThroughAirport3 = flightsProcessor.getFlightsThrough(sampleAirports.get(2));
        List<FlightWithAChange> flightsThroughAirport4 = flightsProcessor.getFlightsThrough(sampleAirports.get(3));
        List<FlightWithAChange> flightsThroughAirport5 = flightsProcessor.getFlightsThrough(sampleAirports.get(4));

        //then
        Assert.assertEquals(12, flightsThroughAirport1.size());
        Assert.assertEquals(2, flightsThroughAirport2.size());
        Assert.assertEquals(4, flightsThroughAirport3.size());
        Assert.assertEquals(1, flightsThroughAirport4.size());
        Assert.assertEquals(0, flightsThroughAirport5.size());

        Assert.assertTrue(flightsThroughAirport1.containsAll(Arrays.asList(flight213, flight214, flight215, flight312,
                flight314, flight315, flight412, flight413, flight415, flight512, flight513, flight514)));
        Assert.assertTrue(flightsThroughAirport2.containsAll(Arrays.asList(flight123, flight321)));
        Assert.assertTrue(flightsThroughAirport3.containsAll(Arrays.asList(flight132, flight134, flight231, flight234)));
        Assert.assertTrue(flightsThroughAirport4.contains(flight341));

    }

    @Test
    public void testFindFlight() {
        //given
        FlightWithAChange flight214 = new FlightWithAChange(airport2, airport1, airport4);
        FlightWithAChange flight234 = new FlightWithAChange(airport2, airport3, airport4);
        FlightWithAChange flight215 = new FlightWithAChange(airport2, airport1, airport5);
        FlightWithAChange flight315 = new FlightWithAChange(airport3, airport1, airport5);
        FlightWithAChange flight412 = new FlightWithAChange(airport4, airport1, airport2);
        FlightWithAChange flight413 = new FlightWithAChange(airport4, airport1, airport3);
        FlightWithAChange flight415 = new FlightWithAChange(airport4, airport1, airport5);
        FlightWithAChange flight512 = new FlightWithAChange(airport5, airport1, airport2);
        FlightWithAChange flight513 = new FlightWithAChange(airport5, airport1, airport3);
        FlightWithAChange flight514 = new FlightWithAChange(airport5, airport1, airport4);

        //when
        List<Flight> findedDirectFlight1 = flightsProcessor.findFlight(airport1, airport2);
        List<Flight> findedDirectFlight2 = flightsProcessor.findFlight(airport1, airport3);
        List<Flight> findedDirectFlight3 = flightsProcessor.findFlight(airport1, airport4);
        List<Flight> findedDirectFlight4 = flightsProcessor.findFlight(airport1, airport5);
        List<Flight> findedDirectFlight5 = flightsProcessor.findFlight(airport2, airport1);
        List<Flight> findedDirectFlight6 = flightsProcessor.findFlight(airport2, airport3);
        List<Flight> findedDirectFlight7 = flightsProcessor.findFlight(airport3, airport1);
        List<Flight> findedDirectFlight8 = flightsProcessor.findFlight(airport3, airport2);
        List<Flight> findedDirectFlight9 = flightsProcessor.findFlight(airport3, airport4);
        List<Flight> findedDirectFlight10 = flightsProcessor.findFlight(airport4, airport1);
        List<Flight> findedDirectFlight11 = flightsProcessor.findFlight(airport5, airport1);

        List<Flight> findedFlight24 = flightsProcessor.findFlight(airport2, airport4);
        List<Flight> findedFlight25 = flightsProcessor.findFlight(airport2, airport5);
        List<Flight> findedFlight35 = flightsProcessor.findFlight(airport3, airport5);
        List<Flight> findedFlight42 = flightsProcessor.findFlight(airport4, airport2);
        List<Flight> findedFlight43 = flightsProcessor.findFlight(airport4, airport3);
        List<Flight> findedFlight45 = flightsProcessor.findFlight(airport4, airport5);
        List<Flight> findedFlight52 = flightsProcessor.findFlight(airport5, airport2);
        List<Flight> findedFlight53 = flightsProcessor.findFlight(airport5, airport3);
        List<Flight> findedFlight54 = flightsProcessor.findFlight(airport5, airport4);

        //then
        Assert.assertEquals(Arrays.asList(directFlight1), findedDirectFlight1);
        Assert.assertEquals(Arrays.asList(directFlight2), findedDirectFlight2);
        Assert.assertEquals(Arrays.asList(directFlight3), findedDirectFlight3);
        Assert.assertEquals(Arrays.asList(directFlight4), findedDirectFlight4);
        Assert.assertEquals(Arrays.asList(directFlight5), findedDirectFlight5);
        Assert.assertEquals(Arrays.asList(directFlight6), findedDirectFlight6);
        Assert.assertEquals(Arrays.asList(directFlight7), findedDirectFlight7);
        Assert.assertEquals(Arrays.asList(directFlight8), findedDirectFlight8);
        Assert.assertEquals(Arrays.asList(directFlight9), findedDirectFlight9);
        Assert.assertEquals(Arrays.asList(directFlight10), findedDirectFlight10);
        Assert.assertEquals(Arrays.asList(directFlight11), findedDirectFlight11);

        Assert.assertEquals(Arrays.asList(flight214, flight234), findedFlight24);
        Assert.assertEquals(Arrays.asList(flight215), findedFlight25);
        Assert.assertEquals(Arrays.asList(flight315), findedFlight35);
        Assert.assertEquals(Arrays.asList(flight412), findedFlight42);
        Assert.assertEquals(Arrays.asList(flight413), findedFlight43);
        Assert.assertEquals(Arrays.asList(flight415), findedFlight45);
        Assert.assertEquals(Arrays.asList(flight512), findedFlight52);
        Assert.assertEquals(Arrays.asList(flight513), findedFlight53);
        Assert.assertEquals(Arrays.asList(flight514), findedFlight54);

    }
}
