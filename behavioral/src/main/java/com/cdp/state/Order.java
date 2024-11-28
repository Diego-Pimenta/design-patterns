package com.cdp.state;

import com.cdp.state.states.Cancelled;
import com.cdp.state.states.Delivered;
import com.cdp.state.states.InTransit;
import com.cdp.state.states.New;
import com.cdp.state.states.OrderState;
import com.cdp.state.states.Paid;

// Context class
public class Order {

    private OrderState currentState;

    public Order() {
        currentState = new New();
    }

    public double cancel() {
        double charges = currentState.handleCancellation();
        currentState = new Cancelled();
        return charges;
    }

    public void paymentSuccessful() {
        currentState = new Paid();
    }

    public void dispatched() {
        currentState = new InTransit();
    }

    public void delivered() {
        currentState = new Delivered();
    }
}
