/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import models.entities.Liked;

public interface LikedRepository extends OrmRepository<Liked> {
    boolean isUserLikedSong(int user_id, int song_id);

    int getCountOfLikesBySongId(int _id);

    boolean deleteLike(Liked entity);


}
