package com.cdp.proxy.model;

import javafx.geometry.Point2D;

public interface Image {

    void setLocation(Point2D point2D);

    Point2D getLocation();

    void render();
}
