package com.silvinovieira.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> fieldMessages = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldErrors() {
        return fieldMessages;
    }

    public void addError(String fieldName, String message) {
        fieldMessages.removeIf(x -> x.getFieldName().equals(fieldName));
        fieldMessages.add(new FieldMessage(fieldName, message));
    }
}
