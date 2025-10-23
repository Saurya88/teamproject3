package org.chamsoft.teamproject3.Utilities;

public class InvalidBookDataException extends RuntimeException {
    public InvalidBookDataException(String message) {
        super("Invalid book data: " + message);
    }
}
