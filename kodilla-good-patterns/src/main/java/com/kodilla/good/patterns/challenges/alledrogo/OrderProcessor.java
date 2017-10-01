package com.kodilla.good.patterns.challenges.alledrogo;

public class OrderProcessor {
    private OrderService orderService;
    private InfoService infoService;
    private OrderRepository orderRepository;

    public OrderProcessor(final OrderService orderService,
                          final InfoService infoService,
                          final OrderRepository orderRepository) {
        this.orderService = orderService;
        this.infoService = infoService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final Order order) {
        boolean isBought = orderService.createOrder(order.getUser(), order.getProduct(),
                order.getOrderTime());

        if (isBought) {
            order.getUser().addOrderToUserHistory(order);
            infoService.informUserAboutOrder(order.getUser());
            orderRepository.addOrderToRepository(order);
            return new OrderDto(order.getUser(), order.getProduct(), true);
        } else {
            return new OrderDto(order.getUser(), order.getProduct(), false);
        }
    }
}
