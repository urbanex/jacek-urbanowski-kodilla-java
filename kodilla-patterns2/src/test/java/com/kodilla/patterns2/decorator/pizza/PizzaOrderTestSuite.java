package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Ordered pizza:\n", description);
    }

    @Test
    public void testThinCrustTomatoSauceHamMushroomsPizzaGetCost() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaThinCrustDecorator(theOrder);
        theOrder = new PizzaTomatoSauceDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaHamDecorator(theOrder);
        theOrder = new PizzaMushroomsDecorator(theOrder);
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(26), calculatedCost);
    }

    @Test
    public void testThinCrustTomatoSauceHamMushroomsPizzaGetDescription() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaThinCrustDecorator(theOrder);
        theOrder = new PizzaTomatoSauceDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaHamDecorator(theOrder);
        theOrder = new PizzaMushroomsDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Ordered pizza:\n" +
                "  - thin-crust\n" +
                "  - tomato sauce\n" +
                "  - cheese\n" +
                "  - ham\n" +
                "  - mushrooms\n", description);
    }

    @Test
    public void testThickCrustBbqSauceCheeseCheeseHamMushroomsOnionPizzaGetCost() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaThickCrustDecorator(theOrder);
        theOrder = new PizzaBbqSauceDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaHamDecorator(theOrder);
        theOrder = new PizzaMushroomsDecorator(theOrder);
        theOrder = new PizzaOnionDecorator(theOrder);
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(35), calculatedCost);
    }

    @Test
    public void testThickCrustBbqSauceCheeseCheeseHamMushroomsOnionPizzaGetDescription() {
        //given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaThickCrustDecorator(theOrder);
        theOrder = new PizzaBbqSauceDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaCheeseDecorator(theOrder);
        theOrder = new PizzaHamDecorator(theOrder);
        theOrder = new PizzaMushroomsDecorator(theOrder);
        theOrder = new PizzaOnionDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Ordered pizza:\n" +
                "  - thick-crust\n" +
                "  - BBQ sauce\n" +
                "  - cheese\n" +
                "  - cheese\n" +
                "  - ham\n" +
                "  - mushrooms\n" +
                "  - onion\n", description);
    }
}