package com.dswjp.muebleria_miley_movil.commons;

public abstract class ResponseDTO {
    protected String message;
    protected boolean success;
    protected String statusCode;

    public ResponseDTO(String message, boolean b, String statusCode) {
    }

    public ResponseDTO() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
