package com.cdp;

import com.cdp.entities.Instance;
import com.cdp.entities.Storage;

public class Main {

    private ResourceFactory factory;

    public Main(ResourceFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        Main aws = new Main(new AWSResourceFactory());
        Instance i1 = aws.createServer(Instance.Capacity.micro, 20480);
        i1.start();;
        i1.stop();

        Main gcp = new Main(new GoogleResourceFactory());
        i1 = gcp.createServer(Instance.Capacity.micro, 20480);
        i1.start();;
        i1.stop();
    }

    public Instance createServer(Instance.Capacity cap, int storageMib) {
        Instance instance = factory.createInstance(cap);
        Storage storage = factory.createStorage(storageMib);
        instance.attachStorage(storage);
        return instance;
    }
}