package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository implements AbstractBaseRepository<Manager>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public ManagerRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException {
        statement = connection.prepareStatement("SELECT MANAGER_SEQ.nextval AS manager_id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("manager_id");
    }

    @Override
    public Manager add(Manager manager) throws SQLException {

        manager.setManagerId(getNextId());

        String url = "INSERT INTO manager(manager_id, manager_name, manager_family, manager_national_code, " +
                "manager_cell_phone) VALUES (?, ?, ?, ?, ?)";

        statement = connection.prepareStatement(url);

        statement.setLong(1, manager.getManagerId());
        statement.setString(2, manager.getManagerName());
        statement.setString(3, manager.getManagerFamily());
        statement.setString(4, manager.getManagerNationalCode());
        statement.setString(5, manager.getManagerCellPhone());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? manager : null;
    }

    @Override
    public Manager update(Manager manager) throws SQLException {
        String url = "UPDATE manager SET manager_name = ?, manager_family = ?, manager_national_code = ?, " +
                "manager_cell_phone = ? WHERE manager_id = ?";

        statement = connection.prepareStatement(url);

        statement.setString(1, manager.getManagerName());
        statement.setString(2, manager.getManagerFamily());
        statement.setString(3, manager.getManagerNationalCode());
        statement.setString(4, manager.getManagerCellPhone());
        statement.setLong(5, manager.getManagerId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? manager : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM manager WHERE manager_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public Manager findById(long id) throws SQLException {
        String url = "SELECT * FROM manager WHERE manager_id = ?";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Manager manager = new Manager(
                resultSet.getLong("manager_id"),
                resultSet.getString("manager_name"),
                resultSet.getString("manager_family"),
                resultSet.getString("manager_national_code"),
                resultSet.getString("manager_cell_phone"));

        return manager;
    }

    @Override
    public List<Manager> findAll() throws SQLException {
        String url = "SELECT * FROM manager";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();

        List<Manager> managers = new ArrayList<>();

        while( resultSet.next() )
        {
            Manager manager = new Manager(
                    resultSet.getLong("manager_id"),
                    resultSet.getString("manager_name"),
                    resultSet.getString("manager_family"),
                    resultSet.getString("manager_national_code"),
                    resultSet.getString("manager_cell_phone"));

            managers.add(manager);
        }

        return managers;
    }

    public Manager findByNameAndFamily(String name, String family) throws SQLException {
        String url = "SELECT * FROM manager WHERE manager_name = ? AND manager_family = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, name);
        statement.setString(2, family);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Manager manager = new Manager(
                resultSet.getLong("manager_id"),
                resultSet.getString("manager_name"),
                resultSet.getString("manager_family"),
                resultSet.getString("manager_national_code"),
                resultSet.getString("manager_cell_phone"));

        return manager;
    }

    public Manager findByNationalCode(String nationalCode) throws SQLException
    {
        String url = "SELECT * FROM manager WHERE manager_national_code = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, nationalCode);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Manager manager = new Manager(
                resultSet.getLong("manager_id"),
                resultSet.getString("manager_name"),
                resultSet.getString("manager_family"),
                resultSet.getString("manager_national_code"),
                resultSet.getString("manager_cell_phone"));

        return manager;
    }

    public Manager findByCellPhone(String cellPhone) throws SQLException
    {
        String url = "SELECT * FROM manager WHERE manager_cell_phone = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, cellPhone);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Manager manager = new Manager(
                resultSet.getLong("manager_id"),
                resultSet.getString("manager_name"),
                resultSet.getString("manager_family"),
                resultSet.getString("manager_national_code"),
                resultSet.getString("manager_cell_phone"));

        return manager;
    }

    @Override
    public void close() throws Exception {

    }
}