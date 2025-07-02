package com.dswjp.muebleria_miley_movil.commons;

public abstract class ResponseDTO {
    protected String message;
    protected boolean success;
    protected String statusCode;

    public ResponseDTO() {
    }

    public ResponseDTO(String message, boolean success, String statusCode) {
        this.message = message;
        this.success = success;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
