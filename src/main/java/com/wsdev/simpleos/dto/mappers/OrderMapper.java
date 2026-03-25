package com.wsdev.simpleos.dto.mappers;

import com.wsdev.simpleos.dto.CustomerDTO;
import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.dto.OrderDTO;
import com.wsdev.simpleos.model.OrderModel;

public class OrderMapper
{
    public static OrderModel dtoToEntity( OrderDTO orderDTO )
    {
        OrderModel orderModel = new OrderModel();

        orderModel.setId( orderDTO.getId() );
        orderModel.setDescription( orderDTO.getDescription() );
        orderModel.setEmployee( EmployeeMapper.dtoToEntity( orderDTO.getEmployee() ) );
        orderModel.setStatus( orderDTO.getStatus() );
        orderModel.setExecutedDate( orderDTO.getExecutedDate() );
        orderModel.setCreatedAt(orderDTO.getCreatedAt() );

        return  orderModel;
    }

    public static OrderDTO entityToDto( OrderModel orderModel )
    {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( orderModel.getId() );
        orderDTO.setDescription( orderModel.getDescription() );
        orderDTO.setCustomer( CustomerMapper.entityToDto( orderModel.getCustomer() ) );
//        if( orderDTO.getCustomer() != null )
//        {
//            CustomerDTO customerDTO = new CustomerDTO();
//
//            customerDTO.setId( orderDTO.getCustomer().getId() );
//            customerDTO.setFirstName( orderDTO.getCustomer().getFirstName() );
//            customerDTO.setLastName( orderDTO.getCustomer().getLastName() );
//            customerDTO.setAddress( orderDTO.getCustomer().getAddress() );
//            customerDTO.setPhone( orderDTO.getCustomer().getPhone() );
//        }
        orderDTO.setEmployee( EmployeeMapper.entityToDto( orderModel.getEmployee() ) );
//        if( orderDTO.getEmployee() != null )
//        {
//            EmployeeDTO employeeDTO = new EmployeeDTO();
//
//            employeeDTO.setId( orderDTO.getEmployee().getId() );
//            employeeDTO.setName( orderDTO.getEmployee().getName() );
//            employeeDTO.setFunction( orderDTO.getEmployee().getFunction() );
//            employeeDTO.setPhone( orderDTO.getEmployee().getPhone() );
//        }
        orderDTO.setStatus( orderModel.getStatus() );
        orderDTO.setExecutedDate( orderModel.getExecutedDate() );
        orderDTO.setCreatedAt( orderModel.getCreatedAt() );

        return orderDTO;
    }
}
