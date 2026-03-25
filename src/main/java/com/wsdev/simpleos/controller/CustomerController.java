package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/customer" )
@Tag( name="Customer", description="Customer endpoints"  )
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus( HttpStatus.OK )
    public List<CustomerDTO> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping( "/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public CustomerDTO getCustomerById( @PathVariable Long id )
    {
        return customerService.getCustomerById( id );
    }

    @PostMapping( "/add" )
    @ResponseStatus( HttpStatus.CREATED )
    public void addCustomer( @RequestBody CustomerDTO customerDTO )
    {
        customerService.addCustomer( customerDTO );
    }

    @PutMapping(  "/update/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void updateCustomer( @PathVariable Long id, @RequestBody CustomerDTO customerDTO )
    {
        customerService.updateCustomer( id, customerDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteCustomer( @PathVariable Long id )
    {
            customerService.deleteCustomer( id );
    }
}
