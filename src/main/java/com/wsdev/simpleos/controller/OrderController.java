package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.OrderDTO;
import com.wsdev.simpleos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/order" )
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders()
    {
        return orderService.getOrders();
    }

    @GetMapping( "/{employeeName}" )
    public List<OrderDTO> getOrdersByEmployeeName( @RequestParam( "employeeName" ) String employeeName )
    {
        return orderService.getOrdersByEmployeeName( employeeName );
    }

    @GetMapping( "/{id}" )
    public OrderDTO getOrderById( @RequestParam( "id" ) Long id )
    {
        return orderService.getOrderById( id );
    }

    @PostMapping( "/add" )
    public void addOrder( @RequestBody OrderDTO orderDTO )
    {
        orderService.addOrder( orderDTO );
    }

    @PutMapping( "/update/{id}" )
    public void updateOrder( @PathVariable Long id, @RequestBody OrderDTO orderDTO )
    {
        orderService.updateOrder( id, orderDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    public void deleteOrder( @PathVariable Long id )
    {
        orderService.deleteOrder( id );
    }
}
