package com.wsdev.simpleos.dto.mappers;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.model.Customer;

public class CustomerMapper
{
    public static CustomerDTO entityToDto( Customer customer )
    {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setAddress( customer.getAddress() );
        customerDTO.setPhone( customer.getPhone() );

        return customerDTO;
    }

    public static Customer DtoToEntity( CustomerDTO customerDTO )
    {
        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setAddress( customerDTO.getAddress() );
        customer.setPhone( customerDTO.getPhone() );

        return customer;
    }
}
