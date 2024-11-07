package com.cdp.flyweight;

import java.time.Duration;

// Flyweight concreto nao compartilhado
public class UserBannedErrorMessage implements ErrorMessage {

    // O estado sera definido aqui
    private String caseId;
    private String remarks;
    private Duration banDuration;
    private String msg;

    public UserBannedErrorMessage(String caseId) {
        this.caseId = caseId;
        remarks = "You violated terms of use.";
        banDuration = Duration.ofDays(2);
        msg = "You are BANNED. Sorry. \nMore information:\n";
        msg += caseId + "\n";
        msg += remarks + "\n";
        msg += "Banned For:" + banDuration.toHours() + " Hours";
    }

    // Ignoramos o argumento do estado extrinseco
    @Override
    public String getText(String code) {
        return msg;
    }

    public String getCaseNo() {
        return caseId;
    }
}
