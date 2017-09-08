package com.kodilla.testing.collection;

import java.util.ArrayList;


public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> results = new ArrayList<>();
        for (Integer number : numbers) {
            if ((int) number % 2 == 0) {
                results.add(number);
            }
        }
        return results;
    }

}
