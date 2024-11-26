package com.cdp.command;

import com.cdp.command.command.Command;

import java.util.LinkedList;
import java.util.List;

// Invoker executing commands
public class MailTasksRunner implements Runnable {

    private static final MailTasksRunner RUNNER = new MailTasksRunner();

    private Thread runner;
    private List<Command> pendingCommands;
    private volatile boolean stop;

    private MailTasksRunner() {
        pendingCommands = new LinkedList<>();
        runner = new Thread(this);
        runner.start();
    }

    public static final MailTasksRunner getInstance() {
        return RUNNER;
    }

    @Override
    public void run() {
        while (true) {
            Command cmd = null;
            synchronized (pendingCommands) {
                if (pendingCommands.isEmpty()) {
                    try {
                        pendingCommands.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Runner interrupted");
                        if (stop) {
                            System.out.println("Runner stopped");
                            return;
                        }
                    }
                } else {
                    cmd = pendingCommands.remove(0);
                }
            }
            if (cmd == null) return;
            cmd.execute();
        }
    }

    public void addCommand(Command cmd) {
        synchronized (pendingCommands) {
            pendingCommands.add(cmd);
            pendingCommands.notifyAll();
        }
    }

    public void shutdown() {
        stop = true;
        runner.interrupt();
    }
}
