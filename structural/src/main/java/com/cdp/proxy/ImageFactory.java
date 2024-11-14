package com.cdp.proxy;

import com.cdp.proxy.dynamic.ImageInvocationHandler;
import com.cdp.proxy.model.Image;

import java.lang.reflect.Proxy;

public class ImageFactory {

//    public static Image getImage(String name) {
//        return new ImageProxy(name);
//    }

    public static Image getImage(String name) {
        return (Image) Proxy.newProxyInstance(
                ImageFactory.class.getClassLoader(),
                new Class[]{Image.class},
                new ImageInvocationHandler(name));
    }
}
