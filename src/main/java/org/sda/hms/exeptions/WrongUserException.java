package org.sda.hms.exeptions;

public class WrongUserException extends RuntimeException {

    public WrongUserException(String message) {
        super(message);
    }
}
