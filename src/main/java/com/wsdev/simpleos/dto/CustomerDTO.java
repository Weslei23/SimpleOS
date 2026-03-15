package com.wsdev.simpleos.dto;

import com.wsdev.simpleos.model.Address;
import com.wsdev.simpleos.model.OrderModel;

import java.util.List;

public class CustomerDTO
{
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String phone;
    private List<OrderModel> orders;

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

    public List<OrderModel> getOrders()
    {
        return orders;
    }

    public void setOrders( List<OrderModel> orders )
    {
        this.orders = orders;
    }
}
