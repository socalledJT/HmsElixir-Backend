package org.sda.hms.exeptions;

public class NotAllowedException extends RuntimeException {

    public NotAllowedException(String message) {
        super(message);
    }
}
