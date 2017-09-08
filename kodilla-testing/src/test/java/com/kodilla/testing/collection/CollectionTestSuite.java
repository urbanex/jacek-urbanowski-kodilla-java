package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Collection Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Collection Test Suite: end");
    }

    @Test //sprawdzi czy klasa zachowuje się poprawnie gdy lista jest pusta
    public void testOddNumbersExterminatorEmptyList() {

        List<Integer> input = new ArrayList<>();
        System.out.println("Testing empty list");
        Assert.assertEquals(input, OddNumbersExterminator.exterminate(input));

    }

    @Test //sprawdzi czy klasa zachowuje się poprawnie gdy lista zawiera liczby parzyste i nieparzyste
    public void testOddNumbersExterminatorNormalList() {

        List<Integer> input = new ArrayList<>();
        int i = 1;
        while (input.size()<10) {
            input.add(i++);
        }

        List<Integer> output = new ArrayList<>();
        int o = 1;
        while (output.size()<5) {
            output.add(2*o++);
        }

        System.out.println("Testing list with odd and even numbers");
        Assert.assertEquals(output, OddNumbersExterminator.exterminate(input));

    }

}
