package com.cdp.mediator.object;

import com.cdp.mediator.UIMediator;
import javafx.scene.control.TextField;

public class TextBox extends TextField implements UIControl {

    private UIMediator mediator;
    private boolean mediatedUpdate;

    public TextBox(UIMediator mediator) {
        this.mediator = mediator;
        this.setText("Textbox");
        this.mediator.register(this);

        this.textProperty().addListener((v, o, n) -> {
            if (!mediatedUpdate) {
                this.mediator.valueChanged(this);
            }
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        mediatedUpdate = true;
        this.setText(control.getControlValue());
        mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return getText();
    }

    @Override
    public String getControlName() {
        return "Textbox";
    }
}
