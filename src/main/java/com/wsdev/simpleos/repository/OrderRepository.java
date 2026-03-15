package com.wsdev.simpleos.repository;

import com.wsdev.simpleos.model.EmployeeModel;
import com.wsdev.simpleos.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long>
{
   List<OrderModel> getOrdersByEmployee( EmployeeModel employeeModel );
}
