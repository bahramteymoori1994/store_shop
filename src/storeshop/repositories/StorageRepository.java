package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageRepository implements AbstractBaseRepository<Storage>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public StorageRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException
    {
        String url = "SELECT storage_seq.nextval AS storage_id FROM DUAL";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("storage_id");
    }

    @Override
    public Storage add(Storage storage) throws SQLException {

        storage.setStorageId(getNextId());

        String url = "INSERT INTO storage(storage_id, employee_id, manager_id) VALUES (?, ?, ?)";
        statement = connection.prepareStatement(url);

        statement.setLong(1, storage.getStorageId());
        statement.setLong(2, storage.getEmployee_id());
        statement.setLong(3, storage.getManager_id());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? storage : null;
    }

    @Override
    public Storage update(Storage storage) throws SQLException {
        String url = "UPDATE storage SET employee_id = ?, manager_id = ? WHERE storage_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, storage.getEmployee_id());
        statement.setLong(2, storage.getManager_id());
        statement.setLong(3, storage.getStorageId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? storage : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM storage WHERE storage_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        statement.executeUpdate();
    }

    @Override
    public Storage findById(long id) throws SQLException {
        String url =  "SELECT * FROM storage WHERE storage_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Storage storage = new Storage(
                resultSet.getLong("storage_id"),
                resultSet.getLong("employee_id"),
                resultSet.getLong("manager_id"));

        return storage;
    }

    @Override
    public List<Storage> findAll() throws SQLException {
        String url = "SELECT * FROM storage";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<Storage> storageList = new ArrayList<>();

        while( resultSet.next() )
        {
            Storage storage = new Storage(
                    resultSet.getLong("storage_id"),
                    resultSet.getLong("employee_id"),
                    resultSet.getLong("manager_id"));

            storageList.add(storage);
        }

        return storageList;
    }

    @Override
    public void close() throws Exception {

    }
}