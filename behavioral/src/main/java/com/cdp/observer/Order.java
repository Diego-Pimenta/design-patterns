package com.cdp.observer;

import com.cdp.observer.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private double itemCost;
    private int count;
    private double discount;
    private double shippingCost;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(String id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public double getTotal() {
        return itemCost - discount + shippingCost;
    }

    public void addItem(double price) {
        itemCost += price;
        count++;
        observers.forEach(o -> o.updated(this));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order#" + id + "\nItem cost:" + itemCost + "\nNo. of items:" + count
                + "\nShipping cost:" + shippingCost + "\nDiscount:" + discount
                + "\nTotal:" + getTotal();
    }
}
