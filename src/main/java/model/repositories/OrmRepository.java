/**
 * @author Gilyazov Marat
 * 11-905
 */

package model.repositories;

import java.util.List;

public interface OrmRepository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T entity);

    void update(T entity);
}

