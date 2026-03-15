package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.dto.mappers.EmployeeMapper;
import com.wsdev.simpleos.model.EmployeeModel;
import com.wsdev.simpleos.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployees()
    {
        return employeeRepository.findAll().stream()
                .map( EmployeeMapper::entityToDto ).toList();
    }

    public EmployeeDTO getEmployeeByName( String name )
    {
        EmployeeModel employeeModel = employeeRepository.getEmployeeByName( name );

        return EmployeeMapper.entityToDto( employeeModel );
    }

    public EmployeeDTO getEmployeeById( Long id )
    {
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow(  () ->  new RuntimeException( "Employee with id: " + id + " not found." ) );
        return EmployeeMapper.entityToDto( employeeModel );
    }

    public void  addEmployee( EmployeeDTO employeeDTO )
    {
        employeeRepository.save( EmployeeMapper.dtoToEntity( employeeDTO ) );
    }

    public void updateEmployee( Long id, EmployeeDTO employeeDTO )
    {
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow(  () ->  new RuntimeException( "Employee with id: " + id + " not found." ) );

        employeeModel.setName( employeeDTO.getName() );
        employeeModel.setPhone( employeeDTO.getPhone() );
        employeeModel.setFunction( employeeDTO.getFunction() );
        employeeModel.setOrders( employeeDTO.getOrder() );

        employeeRepository.save( employeeModel );
    }

    public void deleteEmployee( Long id )
    {
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow(  () ->  new RuntimeException( "Employee with id: " + id + " not found." ) );
        employeeRepository.delete( employeeModel );
    }
}
