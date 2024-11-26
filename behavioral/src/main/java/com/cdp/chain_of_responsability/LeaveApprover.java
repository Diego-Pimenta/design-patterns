package com.cdp.chain_of_responsability;

public interface LeaveApprover {

    void processLeaveApplication(LeaveApplication application);

    String getApprovedRole();
}
