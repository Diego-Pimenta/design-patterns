package com.cdp.interpreter.expression;

import com.cdp.interpreter.context.User;

// Non-terminal expression
public class NotExpression implements PermissionExpression {

    private PermissionExpression expression;

    public NotExpression(PermissionExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(User user) {
        return !expression.interpret(user);
    }

    @Override
    public String toString() {
        return "NOT " + expression;
    }
}
