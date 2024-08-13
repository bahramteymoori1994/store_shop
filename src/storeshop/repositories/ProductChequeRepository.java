package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.ProductCheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductChequeRepository implements AbstractBaseRepository<ProductCheque>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public ProductChequeRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    @Override
    public ProductCheque add(ProductCheque productCheque) throws SQLException {
        String url = "INSERT INTO product_cheque(product_id, cheque_id) VALUES (?, ?)";
        statement = connection.prepareStatement(url);

        statement.setLong(1, productCheque.getChequeId());
        statement.setLong(2, productCheque.getProductId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? productCheque : null;
    }

    @Override
    public ProductCheque update(ProductCheque productCheque) throws SQLException {
        String url = "UPDATE product_cheque SET cheque_id = ?, product_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, productCheque.getChequeId());
        statement.setLong(2, productCheque.getProductId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? productCheque : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM product_cheque WHERE cheque_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public ProductCheque findById(long id) throws SQLException {
        String url = "SELECT * FROM product_cheque WHERE cheque_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        ProductCheque productCheque = new ProductCheque(
                resultSet.getLong("cheque_id"),
                resultSet.getLong("product_id"));

        return productCheque;
    }

    @Override
    public List<ProductCheque> findAll() throws SQLException {
        String url = "SELECT * FROM product_cheque";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<ProductCheque> productChequeList = new ArrayList<>();

        while( resultSet.next() )
        {
            ProductCheque productCheque = new ProductCheque(
                    resultSet.getLong("cheque_id"),
                    resultSet.getLong("product_id"));

            productChequeList.add(productCheque);
        }

        return productChequeList;
    }

    @Override
    public void close() throws Exception {

    }
}