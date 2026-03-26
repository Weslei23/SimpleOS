package com.wsdev.simpleos.exception;

public class CpfAlreadyExistsException extends RuntimeException
{
    public CpfAlreadyExistsException( String cpf )
    {
        super( "Argument 'CPF' already exists with: " + cpf );
    }
}
