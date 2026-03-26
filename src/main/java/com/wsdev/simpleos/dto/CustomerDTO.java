package com.wsdev.simpleos.dto;

import com.wsdev.simpleos.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerDTO
{
    private Long id;

    @NotBlank( message = "Argument 'firstName' must not be null" )
    private String firstName;

    @NotBlank( message = "Argument 'lastName' must not be null" )
    private String lastName;

    @NotNull( message = "Argument 'address' must not be null" )
    private Address address;

    @NotBlank( message = "Argument 'phone' must not be null" )
    @Pattern( regexp = "^(\\(\\d{2}\\)\\s?|\\d{2})\\d{4,5}-?\\d{4}$", message = "Invalid phone number. Please use the format (11) 91234-5678 or 11912345678." )
    private String phone;

    @NotBlank( message = "Argument 'email' must not be null" )
    private String email;

    @NotBlank( message = "Argument 'cpf' must not be null" )
    private String cpf;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf( String cpf )
    {
        this.cpf = cpf;
    }
}
