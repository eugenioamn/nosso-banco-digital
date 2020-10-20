package com.eugeniomoreira.nossobancodigital.domain.exception;

public class InternalServiceErrorException extends RuntimeException {
    public InternalServiceErrorException() {
        super();
    }

    public InternalServiceErrorException(String message) {
        super(message);
    }

    public InternalServiceErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServiceErrorException(Throwable cause) {
        super(cause);
    }
}
