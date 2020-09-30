
package models.repositories;

import models.entities.User;

public interface UserRepository extends OrmRepository<User> {
    boolean emailExist(String email);
}
