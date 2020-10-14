/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import models.entities.Artist;

public interface ArtistRepository extends OrmRepository<Artist> {
    boolean emailExist(String email);
    Artist getByEmail(String email);

}
