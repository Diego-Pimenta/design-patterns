package com.cdp.abstract_factory.entities;

public interface Instance {

    void start();

    void attachStorage(Storage storage);

    void stop();

    enum Capacity {micro, small, large}
}
