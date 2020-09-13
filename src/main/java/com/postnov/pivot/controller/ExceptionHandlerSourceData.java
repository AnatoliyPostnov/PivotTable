package com.postnov.pivot.controller;

import com.postnov.pivot.entity.SourceDataSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionHandlerSourceData extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<Object> sqlException(SQLException ex) {
        SourceDataSQLException sourceDataSQLException = new SourceDataSQLException("SQLException", ex.getMessage());
        return new ResponseEntity<>(sourceDataSQLException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
