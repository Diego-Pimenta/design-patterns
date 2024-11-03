package com.cdp;

// lazy initialization holder class
public class LazyRegistryIODH {

    private LazyRegistryIODH() {
        System.out.println("In LazyRegistryIODH singleton");
    }

    public static LazyRegistryIODH getInstance() {
        return RegistryHolder.INSTANCE;
    }

    private static class RegistryHolder {
        static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
    }
}
