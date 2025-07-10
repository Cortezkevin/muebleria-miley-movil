package com.dswjp.muebleria_miley_movil.commons;

import java.util.Objects;

public class SuccessResponseDTO<T> extends ResponseDTO {
    private T content;

    public SuccessResponseDTO() {
        super();
    }

    public SuccessResponseDTO(String message, boolean success, String statusCode, T content) {
        super(message, success, statusCode);
        this.content = content;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuccessResponseDTO)) return false;
        if (!super.equals(o)) return false;
        SuccessResponseDTO<?> that = (SuccessResponseDTO<?>) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return "SuccessResponseDTO{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", statusCode='" + statusCode + '\'' +
                ", content=" + content +
                '}';
    }
}
