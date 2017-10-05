package com.kodilla.good.patterns.challenges.freshfood.distributors;

import com.kodilla.good.patterns.challenges.freshfood.Order;
import com.kodilla.good.patterns.challenges.freshfood.OrderDTO;

public interface FoodDistributor {

    OrderDTO process(Order order);
    String getDistributorName();

}
