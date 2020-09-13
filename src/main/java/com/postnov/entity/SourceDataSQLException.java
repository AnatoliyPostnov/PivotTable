package com.postnov.entity;

public class SourceDataSQLException {

    private String typeException;

    private String exceptionMessage;

    public String getTypeException() {
        return typeException;
    }

    public void setTypeException(String typeException) {
        this.typeException = typeException;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public SourceDataSQLException(String typeException, String exceptionMessage) {
        this.typeException = typeException;
        this.exceptionMessage = exceptionMessage;
    }
}
