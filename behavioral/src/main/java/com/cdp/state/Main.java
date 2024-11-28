package com.cdp.state;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();

        order.paymentSuccessful();
        order.dispatched();

        order.cancel();
    }
}
