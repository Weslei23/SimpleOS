package com.wsdev.simpleos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "tb_customers" )
public class CustomerModel
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String firstName;
    private String lastName;

    @Embedded
    private Address address;
    private String phone;

    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true ) // Ira mapear por employee na classe Order e caso um registro seja apagadso ele ira deletar nas outras classes.
    private List<OrderModel> orders = new ArrayList<>();

    @Column( unique = true )
    private String email;

    @Column( unique = true )
    private String cpf;

    public CustomerModel( Long id, String firstName, String lastName, Address address, String phone, String email, String cpf )
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.cpf = cpf;
    }

    public CustomerModel()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
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

    public List<OrderModel> getOrders()
    {
        return orders;
    }

    public void setOrders( List<OrderModel> orders )
    {
        this.orders = orders;
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
