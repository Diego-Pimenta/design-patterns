package com.cdp.singleton;

public class Main {

    public static void main(String[] args) {
        EagerRegistry registry = EagerRegistry.getInstance();
        EagerRegistry registry2 = EagerRegistry.getInstance();

        System.out.println(registry == registry2);

        LazyRegistryWithDCL lazySingleton1 = LazyRegistryWithDCL.getInstance();
        LazyRegistryWithDCL lazySingleton2 = LazyRegistryWithDCL.getInstance();

        System.out.println(lazySingleton1 == lazySingleton2);

        // padrao sugerido
        LazyRegistryIODH singleton;
        singleton = LazyRegistryIODH.getInstance();
    }
}