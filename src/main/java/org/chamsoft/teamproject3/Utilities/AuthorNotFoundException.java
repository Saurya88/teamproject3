package org.chamsoft.teamproject3.Utilities;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super("Author not found: " + message);
    }
}
