/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import models.entities.Song;

import java.util.List;

public interface SongRepository extends OrmRepository<Song> {
    List<Song> searchByWords(String words, int filter);

    List<Song> getByArtistId(int artist_id);

    List<Song> getByGenreId(int genre_id);

    List<Song> getByAlbumId(int album_id);

    List<Song> getFromLiked(int user_id);
}


