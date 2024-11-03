package com.cdp.entities;

import com.cdp.Poolable;
import javafx.geometry.Point2D;

public interface Image extends Poolable {

    void draw();

    Point2D getLocation();

    void setLocation(Point2D location);
}
