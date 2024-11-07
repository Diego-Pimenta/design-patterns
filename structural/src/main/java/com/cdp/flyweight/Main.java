package com.cdp.flyweight;

public class Main {

    public static void main(String[] args) {
        SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getError(ErrorMessageFactory.ErrorType.GENERICSYSTEMERROR);
        System.out.println(msg1.getText("4056"));

        UserBannedErrorMessage msg2 = ErrorMessageFactory.getInstance().getUserBannedMessage("1202");
        System.out.println(msg2.getText(null));
    }
}
