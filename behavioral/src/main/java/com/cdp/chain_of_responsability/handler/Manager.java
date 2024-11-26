package com.cdp.chain_of_responsability.handler;

import com.cdp.chain_of_responsability.Employee;
import com.cdp.chain_of_responsability.LeaveApplication;
import com.cdp.chain_of_responsability.LeaveApprover;

public class Manager extends Employee {

    public Manager(LeaveApprover nextApprover) {
        super("Manager", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        switch (application.getType()) {
            case SICK -> application.approve(getApprovedRole());
            case PTO -> {
                if (application.getNoOfDays() <= 5) {
                    application.approve(getApprovedRole());
                    return true;
                }
            }
        }
        return false;
    }
}
