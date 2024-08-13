package storeshop.controllers;

import storeshop.exception.ExceptionWrapper;
import storeshop.model.entities.Storage;
import storeshop.services.StorageService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;

public class StorageController implements AbstractBaseController<Storage>
{
    StorageService storageService = new StorageService();

    @Override
    public Storage add(Storage storage) throws Exception {
        try
        {
            storageService.add(storage);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(storage, e));
        }

        return null;
    }

    @Override
    public Storage update(Storage storage) throws Exception {
        try
        {
            storageService.update(storage);
        }
        catch( SQLIntegrityConstraintViolationException e)
        {
            System.out.println(ExceptionWrapper.getMessage(storage, e));
        }

        return null;
    }

    @Override
    public void remove(long id) throws Exception {
        Storage storage = new Storage();

        try
        {
            if( id == storageService.findById(id).getStorageId() )
            {
                storageService.remove(id);
            }
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(storage, e));
        }
    }

    @Override
    public Storage findById(long id) throws Exception {

        Storage storage = new Storage();

        try
        {
            storageService.findById(id);
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(storage, e));
        }

        return null;
    }

    @Override
    public List<Storage> findAll() throws Exception {
        Storage storage = new Storage();

        try
        {
            storageService.findAll();
        }
        catch( Exception e )
        {
            System.out.println(ExceptionWrapper.getMessage(storage, e));
        }

        return null;
    }
}