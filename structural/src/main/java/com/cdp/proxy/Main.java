package com.cdp.proxy;

import com.cdp.proxy.model.Image;
import javafx.geometry.Point2D;

public class Main {

    public static void main(String[] args) {
        Image image = ImageFactory.getImage("A1.bmp");
        image.setLocation(new Point2D(10, 10));

        System.out.println("Image location: " + image.getLocation());

        System.out.println("Rendering image now...");
        image.render();
    }
}
