package com.example.employee_ms.exception;

public class IdNotFoundException extends RuntimeException{
    private String errMsg;

    public IdNotFoundException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
