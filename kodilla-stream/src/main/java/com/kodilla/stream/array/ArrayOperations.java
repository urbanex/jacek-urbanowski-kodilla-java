package com.kodilla.stream.array;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
        //wersja prostsza
        /*IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);*/

        System.out.println(IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .mapToObj(String::valueOf)
                //lub
                //.mapToObj(n -> "" + n)
                //lub
                //.mapToObj(Integer::toString)
                .collect(Collectors.joining(", ","Numbers in array: ",".")));

        OptionalDouble result = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();

        return result.getAsDouble();
    }

}
