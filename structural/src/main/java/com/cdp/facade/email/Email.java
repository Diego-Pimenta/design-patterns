package com.cdp.facade.email;

public class Email {

    public static EmailBuilder getBuilder() {
        return new EmailBuilder();
    }
}
