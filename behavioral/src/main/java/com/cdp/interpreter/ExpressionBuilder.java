package com.cdp.interpreter;

import com.cdp.interpreter.context.Report;
import com.cdp.interpreter.expression.AndExpression;
import com.cdp.interpreter.expression.NotExpression;
import com.cdp.interpreter.expression.OrExpression;
import com.cdp.interpreter.expression.Permission;
import com.cdp.interpreter.expression.PermissionExpression;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionBuilder {

    private Stack<PermissionExpression> permissions = new Stack<>();
    private Stack<String> operators = new Stack<>();

    public PermissionExpression build(Report report) {
        parse(report.getPermission());
        buildExpressions();
        if (permissions.size() > 1 || !operators.isEmpty()) {
            System.err.println("Error");
        }
        return permissions.pop();
    }

    private void parse(String permission) {
        StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
        while (tokenizer.hasMoreTokens()) {
            String token;
            switch (token = tokenizer.nextToken()) {
                case "and" -> operators.push("and");
                case "not" -> operators.push("not");
                case "or" -> operators.push("or");
                default -> permissions.push(new Permission(token));
            }
        }
    }

    private void buildExpressions() {
        while (!operators.isEmpty()) {
            String operator = operators.pop();
            PermissionExpression perm1;
            PermissionExpression perm2;
            PermissionExpression exp;
            switch (operator) {
                case "not" -> {
                    perm1 = permissions.pop();
                    exp = new NotExpression(perm1);
                }
                case "and" -> {
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp = new AndExpression(perm1, perm2);
                }
                case "or" -> {
                    perm1 = permissions.pop();
                    perm2 = permissions.pop();
                    exp = new OrExpression(perm1, perm2);
                }
                default -> throw new IllegalArgumentException("Unknown operator: " + operator);
            }
            permissions.push(exp);
        }
    }
}
