package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Customer;
import storeshop.services.CustomerService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class CustomerController implements AbstractBaseController<Customer>
{
    CustomerService customerService = new CustomerService();

    @Override
    public Customer add(Customer customer) throws Exception {
        try
        {
            return customerService.add(customer);
        }
        catch( SQLIntegrityConstraintViolationException e )
        {
            System.out.println(ExceptionWrapper.getMessage(customer, e));
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) throws Exception {
        return customerService.update(customer);
    }

    @Override
    public void remove(long id) throws Exception {

        Customer customer = new Customer();

        try
        {
            if( id == customerService.findById(id).getCustomerId() )
            {
                customerService.remove(id);
            }
        }
        catch(SQLException e)
        {
            System.out.println(ExceptionWrapper.getMessage(customer, e));
        }
    }

    @Override
    public Customer findById(long id) throws Exception {

        Customer customer = new Customer();

        try
        {
            return customerService.findById(id);
        }
        catch(Exception e)
        {
            System.out.println(ExceptionWrapper.getMessage(customer, e));
        }

        return null;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        return customerService.findAll();
    }
}