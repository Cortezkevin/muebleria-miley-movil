package com.dswjp.muebleria_miley_movil.commons;

public class SuccessResponseDTO<T> extends ResponseDTO {
    private T content;

    public SuccessResponseDTO() {
        super();
    }

    public SuccessResponseDTO(String message, String statusCode, T content) {
        super(message, true, statusCode);
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
