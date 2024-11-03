package com.cdp.abstract_factory;

import com.cdp.abstract_factory.entities.GoogleCloudStorage;
import com.cdp.abstract_factory.entities.GoogleComputeEngineInstance;
import com.cdp.abstract_factory.entities.Instance;
import com.cdp.abstract_factory.entities.Storage;

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
