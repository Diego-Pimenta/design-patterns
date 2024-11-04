package com.cdp.decorator;

import com.cdp.decorator.entities.Message;
import com.cdp.decorator.entities.TextMessage;

public class Main {

    public static void main(String[] args) {
        Message msg = new TextMessage("The <FORCE> is strong with this one!");
        System.out.println(msg);

        Message decorator = new HtmlEncodedMessage(msg);
        System.out.println(decorator.getContent());

        decorator = new Base64EncodedMessage(decorator);
        System.out.println(decorator.getContent());
    }
}
