package com.cdp;

import com.cdp.entities.EC2Instance;
import com.cdp.entities.Instance;
import com.cdp.entities.S3Storage;
import com.cdp.entities.Storage;

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
