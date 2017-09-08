package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public static List<Integer> exterminate(List<Integer> numbers){
        List<Integer> results = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                results.add(number);
            }
        }
        return results;
    }

}
