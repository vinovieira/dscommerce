package com.silvinovieira.dscommerce.services.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
      super(message);
    }
}
