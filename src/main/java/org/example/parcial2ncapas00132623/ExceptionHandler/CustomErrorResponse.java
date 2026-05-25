package org.example.parcial2ncapas00132623.ExceptionHandler;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime timestamp,
        String message
) {
}