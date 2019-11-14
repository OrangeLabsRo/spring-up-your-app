package com.orange.mediastore;

import java.time.LocalDateTime;

public class ApiError {
    private final int statusCode;
    private final String message;
    private final String details;
    private final LocalDateTime dateTime;

    public ApiError(int statusCode, String message, String details, LocalDateTime dateTime) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
        this.dateTime = dateTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
