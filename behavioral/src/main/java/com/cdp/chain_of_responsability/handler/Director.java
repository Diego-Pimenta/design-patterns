package com.cdp.chain_of_responsability.model;

import com.cdp.chain_of_responsability.Employee;
import com.cdp.chain_of_responsability.LeaveApprover;

public class Director extends Employee {

    public Director(LeaveApprover nextApprover) {
        super("Director", nextApprover);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.PTO) {
            application.approve(getApprovedRole());
            return true;
        }
        return false;
    }
}
