package com.cdp.chain_of_responsability.model;

import com.cdp.chain_of_responsability.Employee;
import com.cdp.chain_of_responsability.LeaveApprover;

public class ProjectLead extends Employee {

    public ProjectLead(LeaveApprover successor) {
        super("Project Lead", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.SICK) {
            if (application.getNoOfDays() <= 2) {
                application.approve(getApprovedRole());
                return true;
            }
        }
        return false;
    }
}
