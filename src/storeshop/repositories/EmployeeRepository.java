package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.controllers.AbstractBaseController;
import storeshop.model.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository implements AbstractBaseController<Employee>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public EmployeeRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException {
        String url = "SELECT EMPLOYEE_SEQ.nextval AS employee_id FROM DUAL";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("employee_id");
    }

    @Override
    public Employee add(Employee employee) throws Exception {
        employee.setEmployeeId(getNextId());
        String url = "INSERT INTO employee(employee_id, manager_id, employee_name, employee_family, employee_cell_phone) " +
                "VALUES(?, ?, ?, ?, ?)";

        statement = connection.prepareStatement(url);

        statement.setLong(1, employee.getEmployeeId());
        statement.setLong(2, employee.getManagerId());
        statement.setString(3, employee.getEmployeeName());
        statement.setString(4, employee.getEmployeeFamily());
        statement.setString(5, employee.getEmployeeCellPhone());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? employee : null;
    }

    @Override
    public Employee update(Employee employee) throws Exception {
        String url = "UPDATE employee SET manager_id = ?, employee_name = ?, employee_family = ?, employee_cell_phone = ? WHERE employee_id = ?" +
                "WHERE employee_id = ?";

        statement = connection.prepareStatement(url);

        statement.setLong(1, employee.getManagerId());
        statement.setString(2, employee.getEmployeeName());
        statement.setString(3, employee.getEmployeeFamily());
        statement.setString(4, employee.getEmployeeCellPhone());
        statement.setLong(5, employee.getEmployeeId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? employee : null;
    }

    @Override
    public void remove(long id) throws Exception {
        String url = "DELETE FROM employee WHERE employee_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        statement.executeUpdate();
    }

    @Override
    public Employee findById(long id) throws Exception {
        String url = "SELECT * FROM employee WHERE employee_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Employee employee = new Employee(
                resultSet.getLong("employee_id"),
                resultSet.getLong("manager_id"),
                resultSet.getString("employee_name"),
                resultSet.getString("employee_family"),
                resultSet.getString("employee_cell_phone"));

        return employee;
    }

    @Override
    public List<Employee> findAll() throws Exception {
        String url = "SELECT * FROM employee";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<Employee> employees = new ArrayList<>();

        while( resultSet.next() )
        {
            Employee employee = new Employee(
                    resultSet.getLong("employee_id"),
                    resultSet.getLong("manager_id"),
                    resultSet.getString("employee_name"),
                    resultSet.getString("employee_family"),
                    resultSet.getString("employee_cell_phone"));

            employees.add(employee);
        }

        return employees;
    }

    public Employee findByNameAndFamily(String name, String family) throws SQLException {
        String url = "SELECT * FROM employee WHERE employee_name = ? AND employee_family = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, name);
        statement.setString(2, family);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Employee employee = new Employee(
                resultSet.getLong("employee_id"),
                resultSet.getLong("manager_id"),
                resultSet.getString("employee_name"),
                resultSet.getString("employee_family"),
                resultSet.getString("employee_cell_phone"));

        return employee;
    }

    public Employee findByCellPhone(String cellPhone) throws SQLException {
        String url = "SELECT * FROM employee WHERE employee_cell_phone = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, cellPhone);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Employee employee = new Employee(
                resultSet.getLong("employee_id"),
                resultSet.getLong("manager_id"),
                resultSet.getString("employee_name"),
                resultSet.getString("employee_family"),
                resultSet.getString("employee_cell_phone"));

        return employee;
    }

    @Override
    public void close() throws Exception {

    }
}