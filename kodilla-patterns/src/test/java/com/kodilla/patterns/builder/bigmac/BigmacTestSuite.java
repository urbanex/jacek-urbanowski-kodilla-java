package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Set;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("cucumber")
                .ingredient("salad")
                .build();

        //When
        String roll = bigmac.getRoll();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        Set<String> ingredients = bigmac.getIngredients();

        //Then
        Assert.assertEquals("with sesame", roll);
        Assert.assertEquals(2, burgers);
        Assert.assertEquals("barbecue", sauce);
        Assert.assertTrue(ingredients.containsAll(Arrays.asList("bacon", "cheese", "cucumber", "salad")));
        Assert.assertEquals(4, ingredients.size());
    }

    @Test
    public void testBigmacBuilderWithNonexistentIngredientVer1() {
        //Given
        IllegalStateException exception = null;
        Bigmac bigmac = null;

        //when
        try {
             bigmac = new Bigmac.BigmacBuilder()
                    .roll("with sesame")
                    .burgers(2)
                    .sauce("barbecue")
                    .ingredient("bacon")
                    .ingredient("cheese")
                    .ingredient("cucumber")
                    .ingredient("tomato")
                    .build();
        } catch (IllegalStateException e) {
            exception = e;
        }

        //Then
        Assert.assertNotNull(exception);
        Assert.assertEquals("No such an ingredient. Available ingredients: " +
                "salad, onion, bacon, shrimp, cheese, cucumber, chilli pepper, mushrooms.", exception.getMessage());
    }

    @Test(expected = IllegalStateException.class)
    public void testBigmacBuilderWithNonexistentIngredientVer2() {
        //when
        new Bigmac.BigmacBuilder()
                .roll("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("cucumber")
                .ingredient("tomato")
                .build();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testBigmacBuilderWithNonexistentIngredientsVer3() {
        //assert
        exception.expect(IllegalStateException.class);
        exception.expectMessage("No such an ingredient. " +
                "Available ingredients: salad, onion, bacon, shrimp, cheese, cucumber, chilli pepper, mushrooms.");

        //when
        new Bigmac.BigmacBuilder()
                .roll("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("cucumber")
                .ingredient("tomato")
                .build();
    }
}
