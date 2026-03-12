package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.dto.mappers.CustomerMapper;
import com.wsdev.simpleos.model.Customer;
import com.wsdev.simpleos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getCustomers()
    {
        return customerRepository.findAll().stream()
                .map( CustomerMapper::entityToDto ).toList();
    }

    public CustomerDTO getCustomerById( long id )
    {
        Customer customer = customerRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Customer with id " + id + " not found!" ) );

        return CustomerMapper.entityToDto( customer );
    }

    public CustomerDTO getCustomerByName( String name )
    {
        Customer customer = customerRepository.getCustomerByFirstName( name );

        return CustomerMapper.entityToDto( customer );
    }

    public void addCustomer( CustomerDTO customerDTO )
    {
        Customer customer = new Customer();

        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setAddress( customerDTO.getAddress() );
        customer.setPhone( customerDTO.getPhone() );

        customerRepository.save( customer );
    }

    public void updateCustomer( Long id, CustomerDTO customerDTO )
    {
        Customer customer = customerRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Customer with id " + id + " not found!" ) );

        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setAddress( customerDTO.getAddress() );
        customer.setPhone( customerDTO.getPhone() );

        customerRepository.save( customer );
    }

    public void deleteCustomer( Long id )
    {
        Customer customer = customerRepository.findById( id ).orElseThrow( () -> new IllegalArgumentException( "Customer with id " + id + " not found!" ) );

        customerRepository.delete( customer );
    }
}
