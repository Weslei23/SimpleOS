package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.dto.mappers.CustomerMapper;
import com.wsdev.simpleos.exception.CpfAlreadyExistsException;
import com.wsdev.simpleos.exception.EmailAlreadyExistsException;
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

        return CustomerMapper.entityToDto( customerModel );
    }

    public CustomerDTO getCustomerByEmail( String email )
    {
        return CustomerMapper.entityToDto( customerRepository.getCustomerByEmail( email ) );
    }

    public CustomerDTO getCustomerByCpf( String cpf )
    {
        return CustomerMapper.entityToDto( customerRepository.getCustomerByCpf( cpf ) );
    }

    public void addCustomer( CustomerDTO customerDTO )
    {
        if ( customerRepository.getCustomerByEmail( customerDTO.getEmail() ) != null )
        {
            throw new EmailAlreadyExistsException( customerDTO.getEmail() );
        }

        if ( customerRepository.getCustomerByCpf( customerDTO.getCpf() ) != null )
        {
            throw new CpfAlreadyExistsException( customerDTO.getEmail() );
        }

        customerRepository.save( CustomerMapper.dtoToEntity( customerDTO ) );
    }

    public void updateCustomer( Long id, CustomerDTO customerDTO )
    {
        CustomerModel customerModel = customerRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        customerModel.setFirstName( customerDTO.getFirstName() );
        customerModel.setLastName( customerDTO.getLastName() );
        customerModel.setAddress( customerDTO.getAddress() );
        customerModel.setPhone( customerDTO.getPhone() );

        if( !customerModel.getEmail().equals( customerDTO.getEmail() ) )
        {
            customerModel.setEmail( customerDTO.getEmail() );
        }
        else
        {
            throw new EmailAlreadyExistsException( customerDTO.getEmail() );
        }

        if( !customerModel.getCpf().equalsIgnoreCase( customerDTO.getCpf() ) )
        {
            customerModel.setCpf( customerDTO.getCpf() );
        }
        else
        {
            throw new CpfAlreadyExistsException( customerDTO.getCpf() );
        }

        customerRepository.save( customerModel );
    }

    public void deleteCustomer( Long id )
    {
        CustomerModel customerModel = customerRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        customerRepository.delete( customerModel );
    }
}
