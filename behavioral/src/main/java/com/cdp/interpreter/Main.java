package com.cdp.interpreter;

import com.cdp.interpreter.context.Report;
import com.cdp.interpreter.context.User;
import com.cdp.interpreter.expression.PermissionExpression;

public class Main {

    public static void main(String[] args) {
        Report report1 = new Report("Cashflow report", "FINANCE_ADMIN OR ADMIN");
        ExpressionBuilder builder = new ExpressionBuilder();

        PermissionExpression exp = builder.build(report1);
        System.out.println(exp);

        User user1 = new User("Dave", "USER", "ADMIN");

        System.out.println("User access report: " + exp.interpret(user1));
    }
}
