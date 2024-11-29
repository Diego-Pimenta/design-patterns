package com.cdp.template_method.template;

import com.cdp.template_method.Order;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Abstract methods defined in template method
public abstract class OrderPrinter {

    public final void printOrder(Order order, String filename) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(start());
            writer.println(formatOrderNumber(order));
            writer.println(formatItems(order));
            writer.println(formatTotal(order));
            writer.println(end());
        }
    }

    // Steps are abstract methods
    protected abstract String start();

    protected abstract String formatOrderNumber(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatTotal(Order order);

    protected abstract String end();
}
