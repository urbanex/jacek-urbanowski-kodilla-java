package com.kodilla.good.patterns.challenges.alledrogo;

import java.time.LocalDateTime;

public class SampleOrder {

    public Order retrieve() {

        User sampleUser = new User("misiek90", "Michal", "Michalski");
        Product sampleProduct = new Product("Vacuum Cleaner");
        LocalDateTime sampleOrderTime = LocalDateTime.of(2017, 10, 01, 12, 8, 23);

        return new Order(sampleUser, sampleProduct, sampleOrderTime);

    }

}
