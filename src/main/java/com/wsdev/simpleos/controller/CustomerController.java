package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/customer" )
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById( @PathVariable Long id )
    {
        return customerService.getCustomerById( id );
    }

    @PostMapping( "/addCustomer" )
    public void addCustomer( @RequestBody CustomerDTO customerDTO )
    {
        customerService.addCustomer( customerDTO );
    }

    @PutMapping("/update/{id}")
    public void updateCustomer( Long id, CustomerDTO customerDTO )
    {
        customerService.updateCustomer( id, customerDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    public void deleteCustomer( @PathVariable Long id )
    {
            customerService.deleteCustomer( id );
    }
}
