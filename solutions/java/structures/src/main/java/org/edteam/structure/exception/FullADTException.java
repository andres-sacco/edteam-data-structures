package org.edteam.structure.exception;

public class FullADTException extends GenericADTException {
    public FullADTException() {
        super("The ADT is full.");
    }

    public FullADTException(String message) {
        super(message);
    }
}
