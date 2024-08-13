package storeshop.repositories;

import storeshop.connection.ConnectionProvider;
import storeshop.model.entities.Product;
import storeshop.model.enums.ProductName;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements AbstractBaseRepository<Product>, AutoCloseable
{
    private Connection connection;
    private PreparedStatement statement;

    public ProductRepository() throws SQLException {
        connection = ConnectionProvider.getConnection();
    }

    private long getNextId() throws SQLException
    {
        String url = "SELECT product_seq.nextval AS product_id FROM DUAL";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return resultSet.getLong("product_id");
    }

    @Override
    public Product add(Product product) throws SQLException {

        product.setProductId(getNextId());

        String url = "INSERT INTO product(product_id, customer_id, storage_id, product_number, product_name, " +
                "product_model, product_buy_price, product_count) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        statement = connection.prepareStatement(url);

        statement.setLong(1, product.getProductId());
        statement.setLong(2, product.getCustomerId());
        statement.setLong(3, product.getStorageId());
        statement.setString(4, product.getProductNumber());
        statement.setInt(5, product.getProductName().ordinal());
        statement.setString(6, product.getProductModel());
        statement.setFloat(7, product.getProductBuyPrice());
        statement.setInt(8, product.getProductCount());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? product : null;
    }

    @Override
    public Product update(Product product) throws SQLException {
        String url = "UPDATE product SET customer_id = ?, storage_id = ?, product_number, product_name = ?, " +
                "product_model = ?, product_buy_price = ?, product_count = ? WHERE product_id = ?";

        statement = connection.prepareStatement(url);

        statement.setLong(1, product.getCustomerId());
        statement.setLong(2, product.getStorageId());
        statement.setString(3, product.getProductNumber());
        statement.setInt(4, product.getProductName().ordinal());
        statement.setString(5, product.getProductModel());
        statement.setFloat(6, product.getProductBuyPrice());
        statement.setInt(7, product.getProductCount());
        statement.setLong(8, product.getProductId());

        int result = statement.executeUpdate();

        return ( result == 1 ) ? product : null;
    }

    @Override
    public void remove(long id) throws SQLException {
        String url = "DELETE FROM product WHERE product_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public Product findById(long id) throws SQLException {
        String url = "SELECT * FROM product WHERE product_id = ?";
        statement = connection.prepareStatement(url);

        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Product product = new Product(
                resultSet.getLong("product_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("storage_id"),
                resultSet.getString("product_number"),
                (resultSet.getInt("product_name") == 0) ? ProductName.MOBILE : ProductName.LAPTOP,
                resultSet.getString("product_model"),
                resultSet.getFloat("product_buy_price"),
                resultSet.getInt("product_count"));

        return product;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        String url = "SELECT * FROM product";
        statement = connection.prepareStatement(url);

        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();

        while( resultSet.next() )
        {
            Product product = new Product(
                    resultSet.getLong("product_id"),
                    resultSet.getLong("customer_id"),
                    resultSet.getLong("storage_id"),
                    resultSet.getString("product_number"),
                    (resultSet.getInt("product_name") == 0) ? ProductName.MOBILE : ProductName.LAPTOP,
                    resultSet.getString("product_model"),
                    resultSet.getFloat("product_buy_price"),
                    resultSet.getInt("product_count"));

            products.add(product);
        }

        return products;
    }

    public Product findByNumber(String productNumber) throws SQLException
    {
        String url = "SELECT * FROM product WHERE product_number = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, productNumber);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Product product = new Product(
                resultSet.getLong("product_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("storage_id"),
                resultSet.getString("product_number"),
                (resultSet.getInt("product_name") == 0) ? ProductName.MOBILE : ProductName.LAPTOP,
                resultSet.getString("product_model"),
                resultSet.getFloat("product_buy_price"),
                resultSet.getInt("product_count"));

        return product;
    }

    //TODO : NEEDS TO BE EXAMINED
    public Product findByName(String productName) throws SQLException
    {
        String url = "SELECT * FROM product WHERE product_name = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, productName.toString());
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Product product = new Product(
                resultSet.getLong("product_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("storage_id"),
                resultSet.getString("product_number"),
                (resultSet.getInt("product_name") == 0) ? ProductName.MOBILE : ProductName.LAPTOP,
                resultSet.getString("product_model"),
                resultSet.getFloat("product_buy_price"),
                resultSet.getInt("product_count"));

        return product;
    }

    public Product findByModel(String model) throws SQLException
    {
        String url = "SELECT * FROM product WHERE product_model = ?";
        statement = connection.prepareStatement(url);

        statement.setString(1, model);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        Product product = new Product(
                resultSet.getLong("product_id"),
                resultSet.getLong("customer_id"),
                resultSet.getLong("storage_id"),
                resultSet.getString("product_number"),
                (resultSet.getInt("product_name") == 0) ? ProductName.MOBILE : ProductName.LAPTOP,
                resultSet.getString("product_model"),
                resultSet.getFloat("product_buy_price"),
                resultSet.getInt("product_count"));

        return product;
    }

    @Override
    public void close() throws Exception {

    }
}