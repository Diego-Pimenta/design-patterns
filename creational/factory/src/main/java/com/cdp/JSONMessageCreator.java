package com.cdp;

import com.cdp.entities.JSONMessage;
import com.cdp.entities.Message;

public class JSONMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
