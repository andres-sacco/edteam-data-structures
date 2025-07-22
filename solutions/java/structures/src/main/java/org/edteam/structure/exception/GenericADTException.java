package org.edteam.structure.exception;

public class GenericADTException extends RuntimeException {
    public GenericADTException() {
        super("There was an error using the adt.");
    }

    public GenericADTException(String message) {
        super(message);
    }
}
