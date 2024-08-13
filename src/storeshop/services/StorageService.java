package storeshop.services;

import storeshop.model.entities.Storage;
import storeshop.repositories.StorageRepository;

import java.util.Collections;
import java.util.List;

public class StorageService implements AbstractBaseService<Storage>
{
    @Override
    public Storage add(Storage storage) throws Exception {
        try(StorageRepository storageRepository = new StorageRepository())
        {
            return storageRepository.add(storage);
        }
    }

    @Override
    public Storage update(Storage storage) throws Exception {
        try(StorageRepository storageRepository = new StorageRepository())
        {
            return storageRepository.update(storage);
        }
    }

    @Override
    public void remove(long id) throws Exception {
        try(StorageRepository storageRepository = new StorageRepository())
        {
            storageRepository.remove(id);
        }
    }

    @Override
    public Storage findById(long id) throws Exception {
        try(StorageRepository storageRepository = new StorageRepository())
        {
            return storageRepository.findById(id);
        }
    }

    @Override
    public List<Storage> findAll() throws Exception {
        try(StorageRepository storageRepository = new StorageRepository())
        {
            return storageRepository.findAll();
        }
    }
}