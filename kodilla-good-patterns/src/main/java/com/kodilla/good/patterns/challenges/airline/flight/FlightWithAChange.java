package com.kodilla.good.patterns.challenges.airline.flight;

import com.kodilla.good.patterns.challenges.airline.Airport;

public class FlightWithAChange extends Flight {
/*    private final DirectFlight directFlight1;
    private final DirectFlight directFlight2;
    private final Airport through;

    public FlightWithAChange(final DirectFlight directFlight1, final DirectFlight directFlight2) {
        super(directFlight1.getFrom(), directFlight2.getTo());
        this.directFlight1 = directFlight1;
        this.directFlight2 = directFlight2;
        this.through = directFlight1.getTo();
    }*/

    private final Airport through;

    public FlightWithAChange(Airport from, Airport through, Airport to) {
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

    /*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightWithAChange that = (FlightWithAChange) o;

        if (!directFlight1.equals(that.directFlight1)) return false;
        return directFlight2.equals(that.directFlight2);
    }

    @Override
    public int hashCode() {
        int result = directFlight1.hashCode();
        result = 31 * result + directFlight2.hashCode();
        return result;
    }*/
}
