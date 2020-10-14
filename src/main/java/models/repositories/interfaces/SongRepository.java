/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories.interfaces;

import models.entities.Song;

import java.util.List;

public interface SongRepository extends OrmRepository<Song> {
    List<Song> searchByWords(String words);

}

