package edu.exceptions;

public class IncorrectArgumentException extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect argument.";
    }

}
