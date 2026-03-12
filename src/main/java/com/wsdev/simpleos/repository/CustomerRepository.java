package com.wsdev.simpleos.repository;

import com.wsdev.simpleos.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    Customer getCustomerByName( String name );
}
