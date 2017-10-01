package com.kodilla.good.patterns.challenges.alledrogo;

import java.time.LocalDateTime;

public interface OrderService {
    boolean createOrder(User user, Product product, LocalDateTime orderTime);
}
