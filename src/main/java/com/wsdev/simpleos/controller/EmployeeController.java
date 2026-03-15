package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/employee" )
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping( "/{name}" )
    public EmployeeDTO getEmployeeByName( @RequestParam String name )
    {
        return employeeService.getEmployeeByName( name );
    }

    @GetMapping( "/{id}" )
    public EmployeeDTO getEmployeeById( @PathVariable Long id )
    {
        return employeeService.getEmployeeById( id );
    }

    @PostMapping( "/add" )
    public void addEmployee( @RequestBody EmployeeDTO employeeDTO )
    {
        employeeService.addEmployee( employeeDTO );
    }

    @PutMapping( "/update/{id}" )
    public void updateEmployee( @PathVariable Long id, @RequestBody EmployeeDTO employeeDTO )
    {
        employeeService.updateEmployee( id, employeeDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    public void deleteEmployee( @PathVariable Long id )
    {
        employeeService.deleteEmployee( id );
    }

}
