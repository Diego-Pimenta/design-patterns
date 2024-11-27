package com.cdp.interpreter.expression;

import com.cdp.interpreter.context.User;

public interface PermissionExpression {

    boolean interpret(User user);
}
