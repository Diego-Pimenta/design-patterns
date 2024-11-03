package com.cdp;

import com.cdp.entities.Instance;
import com.cdp.entities.Storage;

public interface ResourceFactory {

    Instance createInstance(Instance.Capacity capacity);

    Storage createStorage(int capMib);
}
