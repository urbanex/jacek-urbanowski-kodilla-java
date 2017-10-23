package com.kodilla.patterns.builder.bigmac;

import java.util.*;

public final class Bigmac {
    private final String roll;
    private static final String WITH_SESAME = "with sesame", WITHOUT_SESAME = "without sesame";
    private final int burgers;
    private final String sauce;
    private static final String STANDARD = "standard", THOUSAND_ISLANDS = "1000 islands", BARBECUE = "barbecue";
    private final Set<String> ingredients;
    private static final Set<String> availableIngredients =
            new HashSet<>(Arrays.asList("salad", "onion", "bacon", "shrimp", "cheese", "cucumber", "chilli pepper", "mushrooms"));

    private Bigmac(final String roll, final int burgers, final String sauce, final Set<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new HashSet<>(ingredients);
    }

    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private String sauce;
        private Set<String> ingredients = new HashSet<>();

        public BigmacBuilder roll(String roll) {
            if (!(roll.equals(WITH_SESAME) || roll.equals(WITHOUT_SESAME))) {
                throw new IllegalStateException("No such a roll. Available rolls: with sesame, without sesame.");
            }
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalStateException("Such an amount is forbidden. Only 1 to 3 burgers are allowed.");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!(sauce.equals(STANDARD) || sauce.equals(THOUSAND_ISLANDS) || sauce.equals(BARBECUE))) {
                throw new IllegalStateException("No such a sauce. Available sauces: standard, 1000 islands, barbecue.");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!availableIngredients.contains(ingredient)) {
                throw new IllegalStateException("No such an ingredient. Available ingredients: " +
                        "salad, onion, bacon, shrimp, cheese, cucumber, chilli pepper, mushrooms");
            }
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
