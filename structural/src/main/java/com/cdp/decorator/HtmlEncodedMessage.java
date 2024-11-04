package com.cdp.decorator;

import com.cdp.decorator.entities.Message;
import org.apache.commons.text.StringEscapeUtils;

public class HtmlEncodedMessage implements Message {

    // o decorator precisa de um obj do componente concreto
    private Message msg;

    public HtmlEncodedMessage(Message msg) {
        this.msg = msg;
    }

    // comportamento adicional do decorator
    @Override
    public String getContent() {
        return StringEscapeUtils.escapeHtml4(msg.getContent());
    }
}
