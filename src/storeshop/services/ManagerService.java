package storeshop.services;

import storeshop.model.entities.Manager;
import storeshop.repositories.ManagerRepository;

import java.util.List;

public class ManagerService implements AbstractBaseService<Manager>
{
    @Override
    public Manager add(Manager manager) throws Exception {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.add(manager);
        }
    }

    @Override
    public Manager update(Manager manager) throws Exception {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.update(manager);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            managerRepository.remove(id);
        }
    }

    @Override
    public Manager findById(long id) throws Exception {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.findById(id);
        }
    }

    @Override
    public List<Manager> findAll() throws Exception {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.findAll();
        }
    }

    public Manager findByNameAndFamily(String name, String family) throws Exception
    {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.findByNameAndFamily(name, family);
        }
    }

    public Manager findByNationalCode(String nationalCode) throws Exception
    {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.findByNationalCode(nationalCode);
        }
    }

    public Manager findByCellPhone(String cellPhone) throws Exception
    {
        try(ManagerRepository managerRepository = new ManagerRepository())
        {
            return managerRepository.findByCellPhone(cellPhone);
        }
    }
}