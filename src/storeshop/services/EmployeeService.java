package storeshop.services;

import storeshop.model.entities.Employee;
import storeshop.repositories.EmployeeRepository;
import java.util.List;

public class EmployeeService implements AbstractBaseService<Employee>
{
    @Override
    public Employee add(Employee employee) throws Exception {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.add(employee);
        }
    }

    @Override
    public Employee update(Employee employee) throws Exception {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.update(employee);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            employeeRepository.remove(id);
        }
    }

    @Override
    public Employee findById(long id) throws Exception {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.findById(id);
        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.findAll();
        }
    }

    public Employee findByNameAndFamily(String name, String family) throws Exception
    {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.findByNameAndFamily(name, family);
        }
    }

    public Employee findByCellPhone(String cellPhone) throws Exception
    {
        try(EmployeeRepository employeeRepository = new EmployeeRepository())
        {
            return employeeRepository.findByCellPhone(cellPhone);
        }
    }
}