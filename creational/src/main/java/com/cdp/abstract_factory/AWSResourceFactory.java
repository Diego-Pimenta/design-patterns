package com.cdp.abstract_factory;

import com.cdp.abstract_factory.entities.EC2Instance;
import com.cdp.abstract_factory.entities.Instance;
import com.cdp.abstract_factory.entities.S3Storage;
import com.cdp.abstract_factory.entities.Storage;

public class AWSResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new EC2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
