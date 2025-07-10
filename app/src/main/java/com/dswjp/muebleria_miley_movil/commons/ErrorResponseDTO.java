package com.dswjp.muebleria_miley_movil.commons;

import lombok.*;
import lombok.experimental.SuperBuilder;

public class ErrorResponseDTO extends ResponseDTO {
    public ErrorResponseDTO() {
        super();
    }

    public ErrorResponseDTO(String message, String statusCode) {
        super(message, false, statusCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponseDTO)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
