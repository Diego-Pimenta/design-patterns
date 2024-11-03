package com.cdp.abstract_factory;

import com.cdp.abstract_factory.entities.Instance;
import com.cdp.abstract_factory.entities.Storage;

public interface ResourceFactory {

    Instance createInstance(Instance.Capacity capacity);

    Storage createStorage(int capMib);
}
