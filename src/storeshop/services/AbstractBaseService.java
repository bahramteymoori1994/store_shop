package storeshop.services;

import java.util.List;

public interface AbstractBaseService<E>
{
    E add(E entity) throws Exception;
    E update(E entity) throws Exception;
    void remove(long id) throws Exception;
    E findById(long id) throws Exception;
    List<E> findAll() throws Exception;
}