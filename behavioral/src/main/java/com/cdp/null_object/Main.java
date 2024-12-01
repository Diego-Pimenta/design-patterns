package com.cdp.null_object;

public class Main {

    public static void main(String[] args) {
//        ComplexService service = new ComplexService("Simple report", new StorageService());
        ComplexService service = new ComplexService("Simple report", new NullStorageService());
        service.generateReport();
    }
}
