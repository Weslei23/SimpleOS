package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.dto.mappers.CustomerMapper;
import com.wsdev.simpleos.exception.RecordNotFoundException;
import com.wsdev.simpleos.model.CustomerModel;
import com.wsdev.simpleos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService( CustomerRepository customerRepository )
    {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getCustomers()
    {
        return customerRepository.findAll().stream()
                .map( CustomerMapper::entityToDto ).toList();
    }

    public CustomerDTO getCustomerById( long id )
    {
        CustomerModel customerModel = customerRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        return CustomerMapper.entityToDto(customerModel);
    }

    public CustomerDTO getCustomerByName( String name )
    {
        CustomerModel customerModel = customerRepository.getCustomerByFirstName( name );

        return CustomerMapper.entityToDto(customerModel);
    }

    public void addCustomer( CustomerDTO customerDTO )
    {
        customerRepository.save( CustomerMapper.dtoToEntity( customerDTO ) );
    }

    public void updateCustomer( Long id, CustomerDTO customerDTO )
    {
        CustomerModel customerModel = customerRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        customerModel.setFirstName( customerDTO.getFirstName() );
        customerModel.setLastName( customerDTO.getLastName() );
        customerModel.setAddress( customerDTO.getAddress() );
        customerModel.setPhone( customerDTO.getPhone() );

        customerRepository.save( customerModel );
    }

    public void deleteCustomer( Long id )
    {
        CustomerModel customerModel = customerRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        customerRepository.delete( customerModel );
    }
}
