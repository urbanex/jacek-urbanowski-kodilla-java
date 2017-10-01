package com.kodilla.good.patterns.challenges.freshfood;

import java.util.ArrayList;

public class OrdersSample {
    private ArrayList<Product> productsList = new ArrayList<>();
    private ArrayList<Provider> providersList = new ArrayList<>();
    private ArrayList<Customer> customersList = new ArrayList<>();
    private ArrayList<Order> ordersList = new ArrayList<>();

    public ArrayList<Order> retrieve() {

        productsList.add(new Product("Jaja"));
        productsList.add(new Product("Kiełbasa"));
        productsList.add(new Product("Piwo"));
        productsList.add(new Product("Ser"));

        providersList.add(new Provider("Jajka od Zbycha", "Cicha 10, 03-330 Kosów Lacki"));
        providersList.add(new Provider("Dziczyzna od Zdzicha", "Długi Bród 25, 17-200 Długi Bród"));
        providersList.add(new Provider("Domowe piwo od Mariana", "Siemiony 4, 17-315 Siemiony"));
        providersList.add(new Provider("Kozie sery od Andżeli", "Pierzchały 32, 07-100 Pierzchały"));

        customersList.add(new Customer(1001));
        customersList.add(new Customer(1002));
        customersList.add(new Customer(1003));

        ordersList.add(new Order(providersList.get(0), productsList.get(0), 200, customersList.get(0)));
        ordersList.add(new Order(providersList.get(1), productsList.get(1), 100, customersList.get(1)));
        ordersList.add(new Order(providersList.get(2), productsList.get(2), 20, customersList.get(2)));
        ordersList.add(new Order(providersList.get(3), productsList.get(3), 10, customersList.get(0)));

        return new ArrayList<>(ordersList);

    }
}
