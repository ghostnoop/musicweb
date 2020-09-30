
package models.repositories;

import java.util.List;

public interface OrmRepository<T> {
    List<T> getAll();

    T getById(int id);

    boolean save(T entity);

    boolean updateById(T entity, int _id);

    boolean deleteById(int _id);
}

