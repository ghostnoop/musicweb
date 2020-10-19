/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import models.entities.Artist;

import java.util.List;

public interface ArtistRepository extends OrmRepository<Artist> {
    boolean emailExist(String email);
    Artist getByEmail(String email);
    List<Artist> getTopArtistByLiked();
}
