package com.wsdev.simpleos.dto.mappers;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.model.CustomerModel;

public class CustomerMapper
{
    public static CustomerDTO entityToDto( CustomerModel customerModel )
    {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customerModel.getId() );
        customerDTO.setFirstName( customerModel.getFirstName() );
        customerDTO.setLastName( customerModel.getLastName() );
        customerDTO.setAddress( customerModel.getAddress() );
        customerDTO.setPhone( customerModel.getPhone() );

        return customerDTO;
    }

    public static CustomerModel dtoToEntity( CustomerDTO customerDTO )
    {
        CustomerModel customerModel = new CustomerModel();

        customerModel.setId( customerDTO.getId() );
        customerModel.setFirstName( customerDTO.getFirstName() );
        customerModel.setLastName( customerDTO.getLastName() );
        customerModel.setAddress( customerDTO.getAddress() );
        customerModel.setPhone( customerDTO.getPhone() );

        return customerModel;
    }
}
