package com.cdp.proxy.dynamic;

import com.cdp.proxy.model.BitmapImage;
import com.cdp.proxy.model.Image;
import javafx.geometry.Point2D;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// O proxy sera gerado automaticamente a partir do codigo
public class ImageInvocationHandler implements InvocationHandler {

    private static final Method setLocationMethod;
    private static final Method getLocationMethod;
    private static final Method renderMethod;

    // Cache Methods for later comparison
    static {
        try {
            setLocationMethod = Image.class.getMethod("setLocation", Point2D.class);
            getLocationMethod = Image.class.getMethod("getLocation", null);
            renderMethod = Image.class.getMethod("render", null);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    private String filename;
    private Point2D location;
    private BitmapImage image;

    public ImageInvocationHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking methood: " + method.getName());
        if (method.equals(setLocationMethod)) {
            return handleSetLocation(args);
        } else if (method.equals(getLocationMethod)) {
            return handleGetLocation();
        } else if (method.equals(renderMethod)) {
            return handleRender();
        }
        return null;
    }

    private Object handleRender() {
        if (image == null) {
            image = new BitmapImage(filename);
            if (location != null) {
                image.setLocation(location);
            }
        }
        image.render();
        return null;
    }

    private Point2D handleGetLocation() {
        if (image != null) {
            return image.getLocation();
        } else {
            return this.location;
        }
    }

    private Object handleSetLocation(Object[] args) {
        if (image != null) {
            image.setLocation((Point2D) args[0]);
        } else {
            this.location = (Point2D) args[0];
        }
        return null;
    }
}
