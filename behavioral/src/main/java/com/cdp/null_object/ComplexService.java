package com.cdp.null_object;

import com.cdp.null_object.model.Report;
import com.cdp.null_object.model.StorageService;

public class ComplexService {

    private StorageService storage;
    private String reportName;

    public ComplexService(StorageService storage) {
        this.storage = storage;
        reportName = "A Complex Report";
    }

    public ComplexService(String reportName, StorageService storage) {
        this.reportName = reportName;
        this.storage = storage;
    }

    public void generateReport() {
        System.out.println("Starting a complex report build!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done with report..");
        storage.save(new Report(reportName));
    }
}
