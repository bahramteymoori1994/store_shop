package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.ProductCheque;
import storeshop.services.ProductChequeService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;

public class ProductChequeController implements AbstractBaseController<ProductCheque>
{
    ProductChequeService productChequeService = new ProductChequeService();

    @Override
    public ProductCheque add(ProductCheque productCheque) throws Exception {
        try{
            return productChequeService.add(productCheque);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(productCheque, e));
        }

        return null;
    }

    @Override
    public ProductCheque update(ProductCheque productCheque) throws Exception {
        try{
            return productChequeService.update(productCheque);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(productCheque, e));
        }

        return null;
    }

    @Override
    public void remove(long id) throws Exception {
        ProductCheque productCheque = new ProductCheque();

        try
        {
            if( id == productChequeService.findById(id).getChequeId() )
            {
                productChequeService.remove(id);
            }
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(productCheque, e));
        }
    }

    @Override
    public ProductCheque findById(long id) throws Exception {

        ProductCheque productCheque = new ProductCheque();

        try
        {
            return productChequeService.findById(id);
        }
        catch( SQLException e )
        {
            System.out.println(ExceptionWrapper.getMessage(productCheque, e));
        }

        return null;
    }

    @Override
    public List<ProductCheque> findAll() throws Exception {
        ProductCheque productCheque = new ProductCheque();

        try
        {
            return productChequeService.findAll();
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(productCheque, e));
        }

        return null;
    }
}