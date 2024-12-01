package com.cdp.visitor;

import com.cdp.visitor.model.Manager;
import com.cdp.visitor.model.Programmer;
import com.cdp.visitor.model.ProjectLead;
import com.cdp.visitor.model.VicePresident;

public interface Visitor {

    void visit(Programmer programmer);

    void visit(ProjectLead lead);

    void visit(Manager manager);

    void visit(VicePresident vp);
}
