package com.example.employee_ms.exception;

public class DuplicateEntryException extends RuntimeException{
    private String errMsg;

    public DuplicateEntryException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
