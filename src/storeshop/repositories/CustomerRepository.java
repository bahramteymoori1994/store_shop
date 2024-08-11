package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements AbstractBaseRepository<Customer>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public CustomerRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException {
        statement = connection.prepareStatement("SELECT CUSTOMER_SEQ.nextval AS customer_id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("customer_id");
    }

    @Override
    public Customer add(Customer customer) throws SQLException {
        customer.setCustomerId(getNextId());
        String url = "INSERT INTO customer(customer_id, customer_name, customer_family, customer_national_code, " +
                "customer_cell_phone, customer_email) VALUES (?, ?, ?, ?, ?, ?)";

        statement = connection.prepareStatement(url);

        statement.setLong(1, customer.getCustomerId());
        statement.setString(2, customer.getCustomerName());
        statement.setString(3, customer.getCustomerFamily());
        statement.setString(4, customer.getCustomerNationalCode());
        statement.setString(5, customer.getCustomerCellPhone());
        statement.setString(6, customer.getCustomerEmail());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? customer : null;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        String url = "UPDATE customer SET customer_name = ?, customer_family = ?, customer_national_code = ?, " +
                "customer_cell_phone = ?, customer_email = ? WHERE customer_id = ?";

        statement = connection.prepareStatement(url);

        statement.setString(1, customer.getCustomerName());
        statement.setString(2, customer.getCustomerFamily());
        statement.setString(3, customer.getCustomerNationalCode());
        statement.setString(4, customer.getCustomerCellPhone());
        statement.setString(5, customer.getCustomerEmail());
        statement.setLong(6, customer.getCustomerId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? customer : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM customer WHERE customer_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        statement.executeUpdate();
    }

    @Override
    public Customer findById(long id) throws SQLException {
        String url = "SELECT * FROM customer WHERE customer_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Customer customer = new Customer(
                resultSet.getLong("customer_id"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_family"),
                resultSet.getString("customer_national_code"),
                resultSet.getString("customer_cell_phone"),
                resultSet.getString("customer_email")
        );

        return customer;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        String url = "SELECT * FROM customer";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<Customer> customers = new ArrayList<>();

        while( resultSet.next() )
        {
            Customer customer = new Customer(
                    resultSet.getLong("customer_id"),
                    resultSet.getString("customer_name"),
                    resultSet.getString("customer_family"),
                    resultSet.getString("customer_national_code"),
                    resultSet.getString("customer_cell_phone"),
                    resultSet.getString("customer_email")
            );

            customers.add(customer);
        }

        return customers;
    }

    public Customer findByNationalCode(String nationalCode) throws SQLException {
        String url = "SELECT * FROM customer WHERE customer_national_code = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, nationalCode);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Customer customer = new Customer(
                resultSet.getLong("customer_id"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_family"),
                resultSet.getString("customer_national_code"),
                resultSet.getString("customer_cell_phone"),
                resultSet.getString("customer_email")
        );

        return customer;
    }

    public Customer findByNameAndFamily(String name, String family) throws SQLException {
        String url = "SELECT * FROM customer WHERE customer_name = ? AND customer_family = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, name);
        statement.setString(2, family);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Customer customer = new Customer(
                resultSet.getLong("customer_id"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_family"),
                resultSet.getString("customer_national_code"),
                resultSet.getString("customer_cell_phone"),
                resultSet.getString("customer_email")
        );

        return customer;
    }

    public Customer findByCellPhone(String cellPhone) throws SQLException {
        String url = "SELECT * FROM customer WHERE customer_cell_phone = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, cellPhone);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Customer customer = new Customer(
                resultSet.getLong("customer_id"),
                resultSet.getString("customer_name"),
                resultSet.getString("customer_family"),
                resultSet.getString("customer_national_code"),
                resultSet.getString("customer_cell_phone"),
                resultSet.getString("customer_email")
        );

        return customer;
    }

    @Override
    public void close() throws Exception {

    }
}