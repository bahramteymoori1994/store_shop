package storeshop.repositories;

import java.sql.SQLException;
import java.util.List;

public interface AbstractBaseRepository<E>
{
    E add(E entity) throws SQLException;
    E update(E entity) throws SQLException;
    void remove(long id) throws SQLException;
    E findById(long id) throws SQLException;
    List<E> findAll() throws SQLException;
}