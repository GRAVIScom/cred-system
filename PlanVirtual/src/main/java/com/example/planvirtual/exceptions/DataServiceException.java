package com.example.planvirtual.exceptions;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataServiceException extends RuntimeException implements GraphQLError {
    public static final int DEFAULT_ERROR_CODE = -10000;
    private Integer errorCode;
    public DataServiceException() {
        super();
    }
    public DataServiceException(String message) {
        super(message);
    }
    public DataServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataServiceException(Throwable cause) {
        super(cause);
    }
    public DataServiceException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public DataServiceException(Integer errorCode, String message,Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    public Integer getErrorCode() {
        return errorCode != null ? errorCode : DEFAULT_ERROR_CODE;
    }


    @Override
    public List<SourceLocation> getLocations() {
        return Collections.emptyList();
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.ValidationError;
    }
    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> extensions = new LinkedHashMap<>();
        extensions.put("errorCode", getErrorCode());
        extensions.put("errorMessage", getMessage());
        return extensions;
    }
}
