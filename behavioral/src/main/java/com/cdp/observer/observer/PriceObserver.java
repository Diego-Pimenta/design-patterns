package com.cdp.observer.observer;

import com.cdp.observer.Order;

public class PriceObserver implements OrderObserver {

    @Override
    public void updated(Order order) {
        double total = order.getItemCost();

        if (total >= 500) {
            order.setDiscount(20);
        } else if (total >= 200) {
            order.setDiscount(10);
        }
    }
}
