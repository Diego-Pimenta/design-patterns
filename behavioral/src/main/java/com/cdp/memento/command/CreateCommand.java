package com.cdp.memento.command;

import com.cdp.memento.WorkflowDesigner;

public class CreateCommand extends AbstractWorkflowCommand {

    private String name;

    public CreateCommand(WorkflowDesigner designer, String name) {
        super(designer);
        this.name = name;
    }

    @Override
    public void execute() {
        memento = receiver.getMemento();
        receiver.createWorkflow(name);
    }
}
