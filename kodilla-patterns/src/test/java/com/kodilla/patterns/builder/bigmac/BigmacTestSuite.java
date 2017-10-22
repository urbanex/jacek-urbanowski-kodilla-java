package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

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
}
