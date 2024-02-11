package com.example.planvirtual.exceptions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExceptionStatus {
    Integer statusCode;
    Integer errorCode;
    String errorMessage;
}
