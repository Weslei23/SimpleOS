package com.wsdev.simpleos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO
{
    private Long id;

    @NotBlank( message = "Argument 'name' must not be null" )
    private String name;

    @NotBlank( message = "Argument 'phone' must not be null" )
    @Pattern( regexp = "^(\\(\\d{2}\\)\\s?|\\d{2})\\d{4,5}-?\\d{4}$", message = "Invalid phone number. Please use the format (11) 91234-5678 or 11912345678." )
    private String phone;

    @NotBlank( message = "Argument 'function' must not be null" )
    private String function;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getFunction()
    {
        return function;
    }

    public void setFunction( String function )
    {
        this.function = function;
    }
}
