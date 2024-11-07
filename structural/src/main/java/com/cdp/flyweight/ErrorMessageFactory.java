package com.cdp.flyweight;

import java.util.HashMap;
import java.util.Map;

// Fábrica de Flyweight, retorna um flyweight compartilhado com base na chave
public class ErrorMessageFactory {

    private static final ErrorMessageFactory FACTORY = new ErrorMessageFactory();

    private Map<ErrorType, SystemErrorMessage> errorMessages = new HashMap<>();

    private ErrorMessageFactory() {
        errorMessages.put(ErrorType.GENERICSYSTEMERROR, new SystemErrorMessage(
                "A genetic error of type $errorCode occurred. Please refer to:\n",
                "http://google.com/q="));
        errorMessages.put(ErrorType.PAGENOTFOUNDERROR, new SystemErrorMessage(
                "Page not found. An error of type $errorCode occurred. Please refer to:\n",
                "http://google.com/q="));
    }

    public static ErrorMessageFactory getInstance() {
        return FACTORY;
    }

    public SystemErrorMessage getError(ErrorType type) {
        return errorMessages.get(type);
    }

    public UserBannedErrorMessage getUserBannedMessage(String caseId) {
        return new UserBannedErrorMessage(caseId);
    }

    // Serve como chave para obter uma instância flyweight
    public enum ErrorType {GENERICSYSTEMERROR, PAGENOTFOUNDERROR, SERVERERROR}
}
