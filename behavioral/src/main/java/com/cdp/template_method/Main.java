package com.cdp.template_method;

import com.cdp.template_method.template.HtmlPrinter;
import com.cdp.template_method.template.OrderPrinter;
import com.cdp.template_method.template.TextPrinter;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Order order = new Order("1001");

        order.addItem("Soda", 2.50);
        order.addItem("Sandwich", 11.95);
        order.addItem("Pizza", 15.95);

        OrderPrinter printer = new HtmlPrinter();
        printer.printOrder(order, "1001.txt");
    }
}
