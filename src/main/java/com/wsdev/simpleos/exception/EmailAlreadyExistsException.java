package com.wsdev.simpleos.exception;

public class EmailAlreadyExistsException extends RuntimeException
{
    public EmailAlreadyExistsException( String email )
    {
        super( "Argument 'Email' already exists with: " + email );
    }
}
