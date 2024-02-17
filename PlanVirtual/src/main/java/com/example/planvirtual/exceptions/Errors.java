package com.example.planvirtual.exceptions;

public enum Errors {
    LOAN_NOT_FOUND (-20002),
    OTHER_ERROR (-20001);

    private final int errorCode;

    Errors(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
