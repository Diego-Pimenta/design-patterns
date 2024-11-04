package com.cdp.adapter;

import com.cdp.adapter.entities.BusinessCardDesigner;
import com.cdp.adapter.entities.Employee;

public class Main {

    public static void main(String[] args) {
        // padrao class/two-way adapter
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter);
        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designCard(adapter);
        System.out.println(card);

        System.out.println("***************");

        // padrao sugerido - object adapter
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
        card = designer.designCard(objectAdapter);
        System.out.println(card);
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Diego Pimenta");
        employee.setJobTitle("Dev baackend");
        employee.setOfficeLocation("Rua Algum Lugar");
    }
}
