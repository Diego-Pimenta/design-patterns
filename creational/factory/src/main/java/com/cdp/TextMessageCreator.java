package com.cdp;

import com.cdp.entities.Message;
import com.cdp.entities.TextMessage;

public class TextMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
