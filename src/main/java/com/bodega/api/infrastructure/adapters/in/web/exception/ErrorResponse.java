package com.bodega.api.infrastructure.adapters.in.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status; // http status 200, 201, 404, etc.
    private String message;  // Mensaje descriptivo
    private LocalDateTime timestamp;
    private Map<String, String> errors; // Mapa de clave-valor para errores específicos
}