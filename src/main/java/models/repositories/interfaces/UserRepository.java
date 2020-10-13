
package models.repositories.interfaces;

import models.entities.User;

public interface UserRepository extends OrmRepository<User> {
    boolean emailExist(String email);
    User getByEmail(String email);
}
