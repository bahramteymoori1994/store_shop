package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Manager;
import storeshop.services.ManagerService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ManagerController implements AbstractBaseController<Manager>
{
    ManagerService managerService = new ManagerService();

    @Override
    public Manager add(Manager manager) throws Exception {
        try
        {
            return managerService.add(manager);
        }
        catch( SQLIntegrityConstraintViolationException e )
        {
            System.out.println(ExceptionWrapper.getMessage(manager, e));
        }
        return null;
    }

    @Override
    public Manager update(Manager manager) throws Exception {
        return managerService.update(manager);
    }

    @Override
    public void remove(long id) throws Exception {

        Manager manager = new Manager();

        try
        {
            if( id == managerService.findById(id).getManagerId() )
            {
                managerService.remove(id);
            }
        }
        catch(SQLException e)
        {
            System.out.println(ExceptionWrapper.getMessage(manager, e));
        }
    }

    @Override
    public Manager findById(long id) throws Exception {

        Manager manager = new Manager();

        try
        {
            if( id == managerService.findById(id).getManagerId() )
            {
                return managerService.findById(id);
            }
        }
        catch(Exception e)
        {
            System.out.println(ExceptionWrapper.getMessage(manager, e));
        }

        return null;
    }

    @Override
    public List<Manager> findAll() throws Exception {

        Manager manager = new Manager();

        try
        {
            return managerService.findAll();
        }
        catch( Exception e)
        {
            System.out.println(ExceptionWrapper.getMessage(manager, e));
        }

        return null;
    }
}