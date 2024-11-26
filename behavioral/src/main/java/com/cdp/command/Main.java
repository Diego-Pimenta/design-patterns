package com.cdp.command;

import com.cdp.command.command.AddMemberCommand;
import com.cdp.command.command.Command;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        EWSService service = new EWSService();

        Command c1 = new AddMemberCommand("example1@example.com", "inbox", service);
        MailTasksRunner.getInstance().addCommand(c1);

        Command c2 = new AddMemberCommand("example2@example.com", "inbox", service);
        MailTasksRunner.getInstance().addCommand(c2);

        Thread.sleep(3000);
        MailTasksRunner.getInstance().shutdown();
    }
}
