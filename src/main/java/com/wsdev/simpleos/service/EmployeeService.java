package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.dto.mappers.EmployeeMapper;
import com.wsdev.simpleos.exception.CpfAlreadyExistsException;
import com.wsdev.simpleos.exception.RecordNotFoundException;
import com.wsdev.simpleos.model.EmployeeModel;
import com.wsdev.simpleos.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService( EmployeeRepository employeeRepository )
    {
        this.employeeRepository = employeeRepository;
    }

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
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );
        return EmployeeMapper.entityToDto( employeeModel );
    }

    public void  addEmployee( EmployeeDTO employeeDTO )
    {
        if ( employeeRepository.getEmployeeByCpf( employeeDTO.getCpf() ) != null )
        {
            throw new CpfAlreadyExistsException( employeeDTO.getCpf() );
        }
        
        employeeRepository.save( EmployeeMapper.dtoToEntity( employeeDTO ) );
    }

    public void updateEmployee( Long id, EmployeeDTO employeeDTO )
    {
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        employeeModel.setName( employeeDTO.getName() );
        employeeModel.setPhone( employeeDTO.getPhone() );
        employeeModel.setFunction( employeeDTO.getFunction() );

        if( !employeeModel.getCpf().equalsIgnoreCase( employeeDTO.getCpf() ) )
        {
            employeeModel.setCpf( employeeDTO.getCpf() );
        }
        else
        {
            throw new CpfAlreadyExistsException( employeeDTO.getCpf() );
        }

        employeeRepository.save( employeeModel );
    }

    public void deleteEmployee( Long id )
    {
        EmployeeModel employeeModel = employeeRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );
        employeeRepository.delete( employeeModel );
    }
}
