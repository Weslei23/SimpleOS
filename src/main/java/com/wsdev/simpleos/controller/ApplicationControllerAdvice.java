package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.exception.CpfAlreadyExistsException;
import com.wsdev.simpleos.exception.EmailAlreadyExistsException;
import com.wsdev.simpleos.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice
{
    @ExceptionHandler( RecordNotFoundException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String handleNotFoundException( RecordNotFoundException exception )
    {
        return exception.getMessage();
    }

    @ExceptionHandler( EmailAlreadyExistsException.class )
    @ResponseStatus( HttpStatus.CONFLICT )
    public String handleEmailAlreadyExists( EmailAlreadyExistsException exception )
    {
        return exception.getMessage();
    }

    @ExceptionHandler( CpfAlreadyExistsException.class )
    @ResponseStatus( HttpStatus.CONFLICT )
    public String handleCpfAlreadyExists( CpfAlreadyExistsException exception )
    {
        return exception.getMessage();
    }
}