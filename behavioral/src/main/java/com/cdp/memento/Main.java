package com.cdp.memento;

import com.cdp.memento.command.AddStepCommand;
import com.cdp.memento.command.CreateCommand;
import com.cdp.memento.command.WorkflowCommand;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();
        commands.removeLast().undo();
        designer.print();
        commands.removeLast().undo();
        designer.print();
    }

    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if (!commands.isEmpty())
            commands.removeLast().undo();
    }

    private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand(designer, "Leave Workflow");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer, "Create Leave Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer, "Submit Application");
        commands.addLast(cmd);
        cmd.execute();

        cmd = new AddStepCommand(designer, "Application Approved");
        commands.addLast(cmd);
        cmd.execute();

        return commands;
    }
}
