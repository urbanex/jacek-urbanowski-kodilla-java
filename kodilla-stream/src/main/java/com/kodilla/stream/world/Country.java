package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String country;
    private final BigDecimal quantity;

    public Country(final String country, final BigDecimal quantity) {
        this.country = country;
        this.quantity = quantity;
    }

    public BigDecimal getPeopleQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country1 = (Country) o;

        if (country != null ? !country.equals(country1.country) : country1.country != null) return false;
        return quantity != null ? quantity.equals(country1.quantity) : country1.quantity == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
