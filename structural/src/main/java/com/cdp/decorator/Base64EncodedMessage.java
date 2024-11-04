package com.cdp.decorator;

import com.cdp.decorator.entities.Message;

import java.util.Base64;

public class Base64EncodedMessage implements Message {

    private Message msg;

    public Base64EncodedMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public String getContent() {
        return Base64.getEncoder().encodeToString(msg.getContent().getBytes());
    }
}
