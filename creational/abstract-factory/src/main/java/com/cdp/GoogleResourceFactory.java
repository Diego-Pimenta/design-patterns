package com.cdp;

import com.cdp.entities.GoogleCloudStorage;
import com.cdp.entities.GoogleComputeEngineInstance;
import com.cdp.entities.Instance;
import com.cdp.entities.Storage;

public class GoogleResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new GoogleCloudStorage(capMib);
    }
}
