package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.Cheque;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChequeRepository implements AbstractBaseRepository<Cheque>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public ChequeRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException
    {
        String url = "SELECT cheque_seq.nextval AS cheque_id FROM DUAL";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("cheque_id");
    }

    @Override
    public Cheque add(Cheque cheque) throws SQLException {

        cheque.setChequeId(getNextId());
        cheque.setChequeRegisterDate(LocalDateTime.now());

        String url = "INSERT INTO cheque(cheque_id, customer_id, manager_id, cheque_product_count, " +
                "cheque_register_date) VALUES (?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(url);

        statement.setLong(1, cheque.getChequeId());
        statement.setLong(2, cheque.getCustomerId());
        statement.setLong(3, cheque.getManagerId());
        statement.setInt(4, cheque.getChequeProductCount());
        statement.setTimestamp(5, Timestamp.valueOf(cheque.getChequeRegisterDate()));

        int result = statement.executeUpdate();

        return ( result == 1 ) ? cheque : null;
    }

    @Override
    public Cheque update(Cheque cheque) throws SQLException {
        String url = "UPDATE cheque SET customer_id = ?, manager_id = ?, cheque_product_count = ?, " +
                "cheque_register_date = ? WHERE cheque_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, cheque.getCustomerId());
        statement.setLong(2, cheque.getManagerId());
        statement.setInt(3, cheque.getChequeProductCount());
        statement.setTimestamp(4, Timestamp.valueOf(cheque.getChequeRegisterDate()));
        statement.setLong(5, cheque.getChequeId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? cheque : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM cheque WHERE cheque_id = ?";
        statement = connection.prepareStatement(url);

        statement.executeUpdate();
    }

    @Override
    public Cheque findById(long id) throws SQLException {
        String url = "SELECT * FROM cheque WHERE cheque_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Cheque cheque = new Cheque(
                resultSet.getLong("cheque_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("manager_id"),
                resultSet.getInt("cheque_product_count"),
                resultSet.getTimestamp("cheque_register_date").toLocalDateTime());

        return cheque;
    }

    @Override
    public List<Cheque> findAll() throws SQLException {
        String url = "SELECT * FROM cheque";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<Cheque> chequeList = new ArrayList<>();

        while( resultSet.next() )
        {
            Cheque cheque = new Cheque(
                    resultSet.getLong("cheque_id"),
                    resultSet.getLong("customer_id"),
                    resultSet.getLong("manager_id"),
                    resultSet.getInt("cheque_product_count"),
                    resultSet.getTimestamp("cheque_register_date").toLocalDateTime());

            chequeList.add(cheque);
        }

        return chequeList;
    }

    @Override
    public void close() throws Exception {

    }
}