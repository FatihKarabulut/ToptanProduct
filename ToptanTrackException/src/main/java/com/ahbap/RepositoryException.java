package com.ahbap;

public class RepositoryException extends RuntimeException {

    public RepositoryException(String msg) {
        super(msg);

    }
    public RepositoryException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public RepositoryException(Throwable cause) {
        super(cause);
    }
    public RepositoryException() {
        super();
    }

    @Override
    public String toString() {
        return "RepositoryException{" + "msg=" + getMessage() + '}';
    }

}
