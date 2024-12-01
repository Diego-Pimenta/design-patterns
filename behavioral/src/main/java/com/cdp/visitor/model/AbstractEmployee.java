package com.cdp.visitor.model;

import java.util.Collection;
import java.util.Collections;

public abstract class AbstractEmployee implements Employee {

    private static int employeeIdCounter = 101;

    private int performanceRating;
    private String name;
    private int employeeId;

    public AbstractEmployee(String name) {
        this.name = name;
        employeeId = employeeIdCounter++;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPerformanceRating() {
        return performanceRating;
    }

    @Override
    public void setPerformanceRating(int rating) {
        performanceRating = rating;
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return Collections.emptyList();
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }
}
