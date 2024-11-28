package com.cdp.state.states;

public class Delivered implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for item pickup");
        System.out.println("Payment rollback will be initiated upon receiving returned item");
        return 30;
    }
}
