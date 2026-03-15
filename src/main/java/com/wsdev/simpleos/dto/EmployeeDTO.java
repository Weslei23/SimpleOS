package com.wsdev.simpleos.dto;

import com.wsdev.simpleos.model.OrderModel;

import java.util.List;

public class EmployeeDTO
{
    private Long id;
    private String name;
    private String phone;
    private String function;
    private List<OrderModel> orders;

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

    public List<OrderModel> getOrder()
    {
        return orders;
    }

    public void setOrders( List<OrderModel> orders )
    {
        this.orders = orders;
    }
}
