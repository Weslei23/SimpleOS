package com.wsdev.simpleos.repository;

import com.wsdev.simpleos.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>
{
    EmployeeModel getEmployeeByName( String name );
    EmployeeModel getEmployeeByCpf( String cpf );
}
