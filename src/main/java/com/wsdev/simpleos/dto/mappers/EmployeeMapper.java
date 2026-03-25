package com.wsdev.simpleos.dto.mappers;

import com.wsdev.simpleos.dto.EmployeeDTO;
import com.wsdev.simpleos.model.EmployeeModel;

public class EmployeeMapper
{
    public static EmployeeDTO entityToDto( EmployeeModel employeeModel )
    {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employeeModel.getId() );
        employeeDTO.setName( employeeModel.getName() );
        employeeDTO.setPhone( employeeModel.getPhone() );
        employeeDTO.setFunction( employeeModel.getFunction() );

        return employeeDTO;
    }

    public static EmployeeModel dtoToEntity( EmployeeDTO employeeDTO )
    {
        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setId( employeeDTO.getId() );
        employeeModel.setName( employeeDTO.getName() );
        employeeModel.setPhone( employeeDTO.getPhone() );
        employeeModel.setFunction( employeeDTO.getFunction() );

        return employeeModel;
    }
}
