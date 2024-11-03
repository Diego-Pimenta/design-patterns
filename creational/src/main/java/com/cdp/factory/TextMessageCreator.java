package com.cdp.factory;

import com.cdp.factory.entities.Message;
import com.cdp.factory.entities.TextMessage;

public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
