package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {
    @Override
    public Map<Integer, Double> getTemperatures() {
        Map<Integer, Double> stubResult = new HashMap<>();

        // dummy data
        stubResult.put(0, 25.5);
        stubResult.put(1, 26.2);
        stubResult.put(2, 24.8);
        stubResult.put(3, 25.2);
        stubResult.put(4, 26.1);

        return stubResult;
    }
}