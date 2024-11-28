package com.cdp.observer.observer;

import com.cdp.observer.Order;

public interface OrderObserver {

    void updated(Order order);
}
