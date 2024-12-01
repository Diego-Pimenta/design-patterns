package com.cdp.null_object;

import com.cdp.null_object.model.Report;
import com.cdp.null_object.model.StorageService;

// We override all methods
public class NullStorageService extends StorageService {

    @Override
    public void save(Report report) { // The logic depends on you
        System.out.println("Null object save method. Doing nothing");
    }
}
