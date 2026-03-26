package com.wsdev.simpleos.controller;

import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/employee" )
@Tag( name="Employee", description="Employee endpoints" )
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseStatus( HttpStatus.OK )
    public List<EmployeeDTO> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping( "/{name}" )
    @ResponseStatus( HttpStatus.OK )
    public EmployeeDTO getEmployeeByName( @RequestParam String name )
    {
        return employeeService.getEmployeeByName( name );
    }

    @GetMapping( "/{id}" )
    @ResponseStatus( HttpStatus.OK )
    public EmployeeDTO getEmployeeById( @PathVariable Long id )
    {
        return employeeService.getEmployeeById( id );
    }

    @PostMapping( "/add" )
    @ResponseStatus( HttpStatus.CREATED )
    public void addEmployee( @Valid @RequestBody EmployeeDTO employeeDTO )
    {
        employeeService.addEmployee( employeeDTO );
    }

    @PutMapping( "/update/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void updateEmployee( @Valid @PathVariable Long id, @RequestBody EmployeeDTO employeeDTO )
    {
        employeeService.updateEmployee( id, employeeDTO );
    }

    @DeleteMapping( "/delete/{id}" )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void deleteEmployee( @PathVariable Long id )
    {
        employeeService.deleteEmployee( id );
    }

}
