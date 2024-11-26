package com.cdp.chain_of_responsability;

import com.cdp.chain_of_responsability.handler.Director;
import com.cdp.chain_of_responsability.handler.Manager;
import com.cdp.chain_of_responsability.handler.ProjectLead;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LeaveApplication application = LeaveApplication.getBuilder()
                .withType(LeaveApplication.Type.SICK)
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(14))
                .build();

        System.out.println(application);
        System.out.println("**************************************************");
        LeaveApprover approver = createChain();
        approver.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead lead = new ProjectLead(manager);
        return lead;
    }
}
