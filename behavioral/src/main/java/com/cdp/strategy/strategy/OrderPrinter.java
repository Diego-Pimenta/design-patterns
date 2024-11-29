package com.cdp.strategy.strategy;

import com.cdp.strategy.Order;

import java.util.Collection;

// Strategy
public interface OrderPrinter {

    void print(Collection<Order> orders);
}
