package com.kodilla.good.patterns.challenges.alledrogo;

public class ProductOrderService {
    public static void main(String[] args) {
        SampleOrder sampleOrder = new SampleOrder();
        Order order = sampleOrder.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new OrderServiceCashOnDelivery(), new InfoServiceSMS(), new OrderRepositoryElectronics());
        OrderDto orderDto = orderProcessor.process(order);

        if (orderDto.isBought()) {
            System.out.println("SUMMARY: " + orderDto.getProduct().getProductName() + " has been ordered by " + orderDto.getUser().getNickname() + ".");
        } else {
            System.out.println("SUMMARY: The order couldn't be completed.");
        }
    }
}

