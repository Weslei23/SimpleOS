package com.wsdev.simpleos.service;

import com.wsdev.simpleos.dto.OrderDTO;
import com.wsdev.simpleos.dto.mappers.CustomerMapper;
import com.wsdev.simpleos.dto.mappers.EmployeeMapper;
import com.wsdev.simpleos.dto.mappers.OrderMapper;
import com.wsdev.simpleos.exception.RecordNotFoundException;
import com.wsdev.simpleos.model.EmployeeModel;
import com.wsdev.simpleos.model.OrderModel;
import com.wsdev.simpleos.repository.EmployeeRepository;
import com.wsdev.simpleos.repository.OrderRepository;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    private EmployeeRepository employeeRepository;

    public OrderService( OrderRepository orderRepository, EmployeeRepository employeeRepository )
    {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
    }

    /**
     * Get all orders.
     *
     * @return
     */
    public List<OrderDTO> getOrders()
    {
        return orderRepository.findAll().stream()
                .map( OrderMapper::entityToDto ).toList();
    }

    /**
     * Get order by id.
     *
     * @param id
     * @return
     */
    public OrderDTO getOrderById( Long id )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        return OrderMapper.entityToDto( orderModel );
    }

    /**
     *  Filter orders by employee name.
     *
     * @param employeeName
     * @return
     */
    public List<OrderDTO> getOrdersByEmployeeName( String employeeName )
    {
        EmployeeModel employeeModel = employeeRepository.getEmployeeByName( employeeName );

        if( employeeModel == null )
        {
            throw new RuntimeException( "Employee with name: " + employeeName + " not found." );
        }

        return orderRepository.getOrdersByEmployee( employeeModel ).stream()
                .map( OrderMapper::entityToDto ).toList();
    }

    /**
     * Add a new order.
     *
     * @param orderDTO
     */
    public void addOrder( OrderDTO orderDTO )
    {
        orderRepository.save( OrderMapper.dtoToEntity( orderDTO ) );
    }

    /**
     *  Update order by id.
     *
     * @param id
     * @param orderDTO
     */
    public void updateOrder( Long id, OrderDTO orderDTO )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        orderModel.setDescription( orderDTO.getDescription() );
        orderModel.setCustomer( CustomerMapper.dtoToEntity( orderDTO.getCustomer() ) );
        orderModel.setEmployee( EmployeeMapper.dtoToEntity( orderDTO.getEmployee() ) );
        orderModel.setStatus( orderDTO.getStatus() );
        orderModel.setCreatedAt( orderDTO.getCreatedAt() );
        orderModel.setExecutedDate( orderDTO.getExecutedDate() );

        orderRepository.save( orderModel );
    }

    public byte[] generateOrdersReportXlsx() throws Exception
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet( "report" );

        int numRow = 0;

        XSSFRow header = sheet.createRow( numRow++ );

        header.createCell( 0 ).setCellValue( "Cliente" );
        header.createCell( 1 ).setCellValue( "Funcionário" );
        header.createCell( 2 ).setCellValue( "Descrição" );
        header.createCell( 3 ).setCellValue( "Data Execução" );
        header.createCell( 4 ).setCellValue( "Data Criação" );
        header.createCell( 5 ).setCellValue( "Status" );

        for ( OrderModel orderModel : orderRepository.findAll() )
        {
            int numCell = 0;

                XSSFRow row = sheet.createRow( numRow++ );

                XSSFCell cellOrderCustomerName = row.createCell( numCell++ );
                cellOrderCustomerName.setCellValue( orderModel.getCustomer().getFirstName() );

                XSSFCell cellOrderEmployeeName = row.createCell( numCell++ );
                cellOrderEmployeeName.setCellValue( orderModel.getEmployee().getName() );

                XSSFCell cellOrderDescription = row.createCell( numCell++ );
                cellOrderDescription.setCellValue( orderModel.getDescription() );

                XSSFCell cellOrderExecutedDate = row.createCell( numCell++ );
                cellOrderExecutedDate.setCellValue( orderModel.getExecutedDate() );

                XSSFCell cellOrderCreatedAtDate = row.createCell( numCell++ );
                cellOrderCreatedAtDate.setCellValue( orderModel.getCreatedAt() );

                XSSFCell cellOrderStatus = row.createCell( numCell++ );
                cellOrderStatus.setCellValue( orderModel.getStatus().getDescription() );
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }

    /**
     *  Delete order by id
     *
     * @param id
     */
    public void deleteOrder( Long id )
    {
        OrderModel orderModel = orderRepository.findById( id ).orElseThrow( () -> new RecordNotFoundException( id ) );

        orderRepository.delete( orderModel );
    }
}
