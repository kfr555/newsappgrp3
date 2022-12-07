package com.grpf.adminservices.exception;

public class UserNameAlreadyExistsException extends Exception{

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NewsAlreadyExistsException [message=" + message + "]";
    }

    public UserNameAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
