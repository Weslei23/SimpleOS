package com.wsdev.simpleos.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table( name = "tb_orders" )
public class OrderModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String description;
    private LocalDate executedDate;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn( name = "customerId" )
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn( name = "employeeId" )
    private EmployeeModel employee;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public OrderModel()
    {
    }

    public OrderModel( Long id, String description, LocalDate executedDate, OrderStatus status, LocalDateTime createdAt )
    {
        this.id = id;
        this.description = description;
        this.executedDate = executedDate;
        this.status = status;
        this.createdAt = createdAt;
        this.executedDate = executedDate;
    }

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

    public void setExecutedDate( LocalDate executedDate  )
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

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( LocalDateTime createdAt )
    {
        this.createdAt = createdAt;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer( CustomerModel customer )
    {
        this.customer = customer;
    }

    public EmployeeModel getEmployee()
    {
        return employee;
    }

    public void setEmployee( EmployeeModel employee )
    {
        this.employee = employee;
    }
}
