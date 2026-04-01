package com.wsdev.simpleos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "tb_employees" )
public class EmployeeModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String phone;
    private String function;

    @OneToMany( mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true ) // Ira mapear por employee na classe Order e caso um registro seja apagadso ele ira deletar nas outras classes.
    private List<OrderModel> orders = new ArrayList<>();

    private String cpf;

    public EmployeeModel()
    {

    }

    public EmployeeModel( Long id, String name, String phone, String function, String cpf )
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.function = function;
        this.cpf = cpf;
    }

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

    public List<OrderModel> getOrders()
    {
        return orders;
    }

    public void setOrders( List<OrderModel> orders )
    {
        this.orders = orders;
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
