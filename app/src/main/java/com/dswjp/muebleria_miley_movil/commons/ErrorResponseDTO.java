package com.dswjp.muebleria_miley_movil.commons;

import lombok.*;
import lombok.experimental.SuperBuilder;

public class ErrorResponseDTO extends ResponseDTO {
    public ErrorResponseDTO(String message, String statusCode) {
        super(message, false, statusCode);
    }
}
