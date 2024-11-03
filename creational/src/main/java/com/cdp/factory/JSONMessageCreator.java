package com.cdp.factory;

import com.cdp.factory.entities.JSONMessage;
import com.cdp.factory.entities.Message;

public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
