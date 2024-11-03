package com.cdp.factory.entities;

public abstract class Message {

    public abstract String getContent();

    public void addDefaultHeaders() {
        // ...
    }

    public void encrypt() {
        // ...
    }
}
