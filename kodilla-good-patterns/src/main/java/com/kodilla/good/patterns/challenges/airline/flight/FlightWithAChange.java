package com.kodilla.good.patterns.challenges.airline.flight;

import com.kodilla.good.patterns.challenges.airline.Airport;

public class FlightWithAChange extends Flight {
    private final Airport through;

    public FlightWithAChange(final Airport from, final Airport through, final Airport to) {
        super(from, to);
        this.through = through;
    }

    @Override
    public String toString() {
        int number1 = from.getDirectFlightToList().get(from.getDirectFlightToList().indexOf(new DirectFlight(from, through))).getNumber();
        int number2 = to.getDirectFlightFromList().get(to.getDirectFlightFromList().indexOf(new DirectFlight(through, to))).getNumber();

        return "Flights " + number1 + " & " + number2 +
                ": " + from.getAirportIndicator() + " - " + through.getAirportIndicator() + " - " + to.getAirportIndicator() +
                " (" + from + " - " + through + " - " + to +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightWithAChange that = (FlightWithAChange) o;

        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;
        return through.equals(that.through);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + through.hashCode();
        return result;
    }
}
