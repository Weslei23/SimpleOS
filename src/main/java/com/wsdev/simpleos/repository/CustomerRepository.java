package com.wsdev.simpleos.repository;

import com.wsdev.simpleos.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>
{
    CustomerModel getCustomerByFirstName( String firstName );
}
