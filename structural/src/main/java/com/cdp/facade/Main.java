package com.cdp.facade;

public class Main {

    public static void main(String[] args) {
        Order order = new Order("101", 99.99);
        EmailFacade facade = new EmailFacade();

        boolean result = facade.sendOrderEmail(order);

        System.out.println("Order Email " + (result ? "sent!" : "NOT sent..."));
    }
}
