package com.cdp.visitor;

import com.cdp.visitor.model.Employee;
import com.cdp.visitor.model.Manager;
import com.cdp.visitor.model.Programmer;
import com.cdp.visitor.model.ProjectLead;
import com.cdp.visitor.model.VicePresident;

import java.util.Date;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Employee emps = buildOrganization();
        Visitor visitor = new PrintVisitor();

        visitOrgStructure(emps, visitor);
        System.out.println("***************************************");
        appraisal(emps, new Random(new Date().getTime()));

        AppraisalVisitor visitor2 = new AppraisalVisitor();
        visitOrgStructure(emps, visitor2);

        visitor = new PrintVisitor(visitor2.getFinalRatings());
        visitOrgStructure(emps, visitor);
    }

    private static Employee buildOrganization() {
        Programmer p1 = new Programmer("Luma", "Python");
        Programmer p2 = new Programmer("Diego", "Hunt");
        Programmer p3 = new Programmer("Nuno", "Excel");
        Programmer p4 = new Programmer("John", "Java");

        ProjectLead pl1 = new ProjectLead("Bruno", p1, p2);
        ProjectLead pl2 = new ProjectLead("Duda", p3, p4);

        Manager m1 = new Manager("Charles I", pl1);
        Manager m2 = new Manager("Charles II", pl2);

        return new VicePresident("Eduard", m1, m2);
    }

    private static void visitOrgStructure(Employee emp, Visitor visitor) {
        emp.accept(visitor);
        emp.getDirectReports().forEach(e -> visitOrgStructure(e, visitor));
    }

    private static void appraisal(Employee emp, Random random) {
        int rating = random.nextInt(6);
        emp.setPerformanceRating(rating < 1 ? 1 : rating);
        emp.getDirectReports().forEach(r -> appraisal(r, random));
    }
}
