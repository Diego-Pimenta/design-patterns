package com.cdp;

import com.cdp.entities.Message;

public class Main {

    public static void main(String[] args) {
        printMessage(new JSONMessageCreator());

        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg);
    }
}
