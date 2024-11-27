package com.cdp.mediator.object;

import com.cdp.mediator.UIMediator;
import javafx.scene.control.Label;

public class Label extends Label implements UIControl {

    private UIMediator mediator;
    private boolean mediatedUpdate;

    public Label(UIMediator mediator) {
        this.mediator = mediator;
        this.setMinWidth(100);
        this.setText("Label");
        mediator.register(this);
    }

    @Override
    public void controlChanged(UIControl control) {
        setText(control.getControlValue());
    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "Label";
    }
}
