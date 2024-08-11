package storeshop.services;

import storeshop.model.entities.Customer;
import storeshop.repositories.CustomerRepository;

import java.util.List;

public class CustomerService implements AbstractBaseService<Customer>
{
    @Override
    public Customer add(Customer customer) throws Exception {
        try(CustomerRepository customerRepository = new CustomerRepository())
        {
            return customerRepository.add(customer);
        }
    }

    @Override
    public Customer update(Customer customer) throws Exception {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.update(customer);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            customerRepository.remove(id);
        }
    }

    @Override
    public Customer findById(long id) throws Exception {
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.findById(id);
        }
    }

    @Override
    public List<Customer> findAll() throws Exception{
        try( CustomerRepository customerRepository = new CustomerRepository() )
        {
            return customerRepository.findAll();
        }
    }
}