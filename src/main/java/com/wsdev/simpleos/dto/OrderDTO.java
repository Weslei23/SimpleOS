package com.wsdev.simpleos.dto;

import com.wsdev.simpleos.model.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDTO
{
    private Long id;
    private String description;
    private LocalDate executedDate;
    private OrderStatus status;
    private CustomerDTO customer;
    private EmployeeDTO employee;
    private LocalDateTime createdAt;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public LocalDate getExecutedDate()
    {
        return executedDate;
    }

    public void setExecutedDate( LocalDate executedDate )
    {
        this.executedDate = executedDate;
    }

    public OrderStatus getStatus()
    {
        return status;
    }

    public void setStatus( OrderStatus status )
    {
        this.status = status;
    }

    public CustomerDTO getCustomer()
    {
        return customer;
    }

    public void setCustomer( CustomerDTO customer )
    {
        this.customer = customer;
    }

    public EmployeeDTO getEmployee()
    {
        return employee;
    }

    public void setEmployee( EmployeeDTO employee )
    {
        this.employee = employee;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( LocalDateTime createdAt )
    {
        this.createdAt = createdAt;
    }
}
