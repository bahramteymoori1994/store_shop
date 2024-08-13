package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Cheque;
import storeshop.services.ChequeService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ChequeController implements AbstractBaseController<Cheque>
{
    ChequeService chequeService = new ChequeService();

    @Override
    public Cheque add(Cheque cheque) throws Exception {
        try
        {
            return chequeService.add(cheque);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(cheque, e));
        }

        return null;
    }

    @Override
    public Cheque update(Cheque cheque) throws Exception {
        try
        {
            return chequeService.update(cheque);
        }
        catch( SQLIntegrityConstraintViolationException e )
        {
            System.out.println(ExceptionWrapper.getMessage(cheque, e));
        }

        return null;
    }

    @Override
    public void remove(long id) throws Exception {

        Cheque cheque = new Cheque();

        try
        {
            if(id == chequeService.findById(id).getChequeId())
            {
                chequeService.remove(id);
            }
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(cheque, e));
        }
    }

    @Override
    public Cheque findById(long id) throws Exception {

        Cheque cheque = new Cheque();

        try
        {
            return chequeService.findById(id);
        }
        catch( SQLException e )
        {
            System.out.println(ExceptionWrapper.getMessage(cheque, e));
        }

        return null;
    }

    @Override
    public List<Cheque> findAll() throws Exception {

        Cheque cheque = new Cheque();

        try
        {
            return chequeService.findAll();
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(cheque, e));
        }

        return null;
    }
}