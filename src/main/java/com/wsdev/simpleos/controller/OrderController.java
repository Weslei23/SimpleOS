package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.OrderDTO;
import com.wsdev.simpleos.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/order" )
@Tag( name="Order", description="Order endpoints" )
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus( HttpStatus.OK )
    public List<OrderDTO> getOrders( @RequestParam( required = false  ) String employeeName )
    {
        if( !(employeeName == null) && !employeeName.isEmpty() )
        {
            return orderService.getOrdersByEmployeeName( employeeName );
        }

        return orderService.getOrders();
    }

    @GetMapping( "/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public OrderDTO getOrderById( @PathVariable( "id" ) Long id )
    {
        return orderService.getOrderById( id );
    }

    @PostMapping( "/add" )
    @ResponseStatus( HttpStatus.CREATED )
    public void addOrder( @RequestBody OrderDTO orderDTO )
    {
        orderService.addOrder( orderDTO );
    }

    @PutMapping( "/update/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void updateOrder( @PathVariable Long id, @RequestBody OrderDTO orderDTO )
    {
        orderService.updateOrder( id, orderDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteOrder( @PathVariable Long id )
    {
        orderService.deleteOrder( id );
    }
}
