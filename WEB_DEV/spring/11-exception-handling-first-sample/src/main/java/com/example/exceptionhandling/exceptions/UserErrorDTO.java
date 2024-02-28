package com.example.exceptionhandling.exceptions;

/**
 * Custom DTO class for handling user-related errors.
 */
public class UserErrorDTO {

    private int status; // HTTP status code

    private String message; // Error message

    private long timeStamp; // Timestamp of the error

    /**
     * Getter method for retrieving the HTTP status code.
     * @return The HTTP status code.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for setting the HTTP status code.
     * @param status The HTTP status code to set.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Getter method for retrieving the error message.
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for setting the error message.
     * @param message The error message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for retrieving the timestamp of the error.
     * @return The timestamp of the error.
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Setter method for setting the timestamp of the error.
     * @param timeStamp The timestamp of the error to set.
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
