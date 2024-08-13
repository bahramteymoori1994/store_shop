package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Product;
import storeshop.model.enums.ProductName;
import storeshop.services.ProductService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;

public class ProductController implements AbstractBaseController<Product>
{
    ProductService productService = new ProductService();

    @Override
    public Product add(Product product) throws Exception {
        try
        {
            return productService.add(product);
        }
        catch(SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }

    @Override
    public Product update(Product product) throws Exception {
        try
        {
            return productService.update(product);
        }
        catch(SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }

    @Override
    public void remove(long id) throws Exception {
        Product product = new Product();

        try{
            if( id == productService.findById(id).getProductId() )
            {
                productService.remove(id);
            }
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }
    }

    @Override
    public Product findById(long id) throws Exception {
        Product product = new Product();

        try
        {
            return productService.findById(id);
        }
        catch( SQLException e )
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }

    @Override
    public List<Product> findAll() throws Exception {

        Product product = new Product();

        try
        {
            return productService.findAll();
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }

    public Product findByNumber(String productNumber) throws Exception
    {
        Product product = new Product();

        try
        {
            return productService.findByNumber(productNumber);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }

//    public Product findByName(String productName) throws Exception
//    {
//        Product product = new Product();
//
//        try
//        {
//            return productService.findByName(productName);
//        }
//        catch( Exception e )
//        {
//            System.out.println(ExceptionWrapper.getMessage(product, e));
//        }
//
//        return null;
//    }

    public Product findByModel(String model) throws Exception
    {
        Product product = new Product();

        try
        {
            return productService.findByModel(model);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(product, e));
        }

        return null;
    }
}