package com.cdp.memento.command;

import com.cdp.memento.WorkflowDesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {

    protected WorkflowDesigner.Memento memento;
    protected WorkflowDesigner receiver;

    public AbstractWorkflowCommand(WorkflowDesigner designer) {
        receiver = designer;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
