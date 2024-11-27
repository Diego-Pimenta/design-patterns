package com.cdp.mediator.object;

public interface UIControl {

    void controlChanged(UIControl control);

    String getControlValue();

    String getControlName();
}
