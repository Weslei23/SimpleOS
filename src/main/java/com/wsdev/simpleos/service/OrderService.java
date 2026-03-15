package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.OrderDTO;
import com.wsdev.simpleos.dto.mappers.OrderMapper;
import com.wsdev.simpleos.model.EmployeeModel;
import com.wsdev.simpleos.model.OrderModel;
import com.wsdev.simpleos.repository.EmployeeRepository;
import com.wsdev.simpleos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    private EmployeeRepository employeeRepository;

    public List<OrderDTO> getOrders()
    {
        return orderRepository.findAll().stream()
                .map( OrderMapper::entityToDto ).toList();
    }

    public OrderDTO getOrderById( Long id )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Order with id: " + id + " not found." ) );

        return OrderMapper.entityToDto( orderModel );
    }

    public List<OrderDTO> getOrdersByEmployeeName( String employeeName )
    {
        EmployeeModel employeeModel = employeeRepository.getEmployeeByName( employeeName );

        if( employeeModel == null )
        {
            throw new RuntimeException("Employee with name: " + employeeName + " not found.");
        }

        return orderRepository.getOrdersByEmployee( employeeModel ).stream()
                .map( OrderMapper::entityToDto ).toList();
    }

    public void addOrder( OrderDTO orderDTO )
    {
        orderRepository.save( OrderMapper.dtoToEntity( orderDTO ) );
    }

    public void updateOrder( Long id, OrderDTO orderDTO )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Order with id: " + id + " not found." ) );

        orderModel.setDescription( orderDTO.getDescription() );
        orderModel.setCustomer( orderDTO.getCustomer() );
        orderModel.setEmployee( orderDTO.getEmployee() );
        orderModel.setStatus( orderDTO.getStatus() );
        orderModel.setCreatedAt( orderDTO.getCreatedAt() );
        orderModel.setExecutedDate( orderDTO.getExecutedDate() );

        orderRepository.save( orderModel );
    }

    public void deleteOrder( Long id )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Order with id: " + id + " not found." ) );

        orderRepository.delete( orderModel );
    }
}
