package com.cdp.mediator.object;

import com.cdp.mediator.UIMediator;
import javafx.scene.control.Slider;

public class Slider extends Slider implements UIControl {

    private UIMediator mediator;
    private boolean mediatedUpdate;

    public Slider(UIMediator mediator) {
        this.mediator = mediator;
        setMin(0);
        setMax(50);
        setBlockIncrement(5);
        mediator.register(this);

        this.valueProperty().addListener((v, o, n) -> {
            if (!mediatedUpdate) {
                this.mediator.valueChanged(this);
            }
        });
    }

    @Override
    public void controlChanged(UIControl control) {
        mediatedUpdate = true;
        setValue(Double.valueOf(control.getControlValue()));
        mediatedUpdate = false;
    }

    @Override
    public String getControlValue() {
        return Double.toString(getValue());
    }

    @Override
    public String getControlName() {
        return "Slider";
    }
}
