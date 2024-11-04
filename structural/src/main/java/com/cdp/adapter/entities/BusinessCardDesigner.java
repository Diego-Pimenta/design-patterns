package com.cdp.adapter.entities;

import com.cdp.adapter.Customer;

public class BusinessCardDesigner {

    public String designCard(Customer customer) {
        String card = "";
        card += customer.getName();
        card += "\n" + customer.getDesignation();
        card += "\n" + customer.getAddress();
        return card;
    }
}
