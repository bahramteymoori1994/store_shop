package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Employee;
import storeshop.services.EmployeeService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class EmployeeController implements AbstractBaseController<Employee>
{
    EmployeeService employeeService = new EmployeeService();

    @Override
    public Employee add(Employee employee) throws Exception {
        try{
            return employeeService.add(employee);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }

        return null;
    }

    @Override
    public Employee update(Employee employee) throws Exception {
        try{
            return employeeService.add(employee);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }

        return null;
    }

    @Override
    public void remove(long id) throws Exception
    {
        Employee employee = new Employee();

        try
        {
            if( id == employeeService.findById(id).getEmployeeId() )
            {
                employeeService.remove(id);
            }
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }
    }

    @Override
    public Employee findById(long id) throws Exception {

        Employee employee = new Employee();

        try
        {
            return employeeService.findById(id);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }

        return null;
    }

    public Employee findByNameAndFamily(String name, String family) throws Exception
    {
        Employee employee = new Employee();

        try
        {
            return employeeService.findByNameAndFamily(name, family);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }

        return null;
    }

    public Employee findByCellPhone(String cellPhone) throws Exception
    {
        Employee employee = new Employee();

        try
        {
            return employeeService.findByCellPhone(cellPhone);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(employee, e));
        }

        return null;
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return employeeService.findAll();
    }
}