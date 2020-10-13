/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import models.entities.Album;
import models.entities.Artist;
import models.entities.Song;
import models.entities.User;
import models.repositories.interfaces.RowMapper;
import models.repositories.interfaces.SongRepository;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SongRepositoryJdbc implements SongRepository {
    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    public SongRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    private final RowMapper<Song> songRowMapper = row -> Song.builder()
            .id(row.getInt(1))
            .artist_id(Artist.builder()
                    .id(row.getInt("artist_id"))
                    .email(row.getString("email"))
                    .name(row.getString("name"))
                    .lastname(row.getString("lastname"))
                    .avatar_img(row.getString("avatar_img"))
                    .created_at(row.getDate("created_at")).build())
            .title(row.getString("title"))
            .cover_img(row.getString("cover_img"))
            .music_url(row.getString("music_url"))
            .album_id(Album.builder()
                    .id(row.getObject("album_id") == null ? 0 :
                            row.getInt("album_id")).build())
            .build();

    //SELECT song.`id`,`atist_id`,artist.email,artist.name,artist.lastname,artist.avatar_img,artist.created_at, song.title,song.cover_img,song.music_url,song.album_id AS album_id FROM `song` INNER JOIN `artist` on song.atist_id=artist.id LEFT JOIN album on song.album_id=album.id
    @Override
    public List<Song> getAll() {
        String GET_ALL = "SELECT song.`id`,`atist_id`,artist.email,artist.name,artist.lastname," +
                "artist.avatar_img,artist.created_at, song.title,song.cover_img,song.music_url," +
                "song.album_id AS album_id FROM `song` INNER JOIN `artist` on song.atist_id=artist.id " +
                "LEFT JOIN album on song.album_id=album.id";

        return simpleJdbc.query(GET_ALL, songRowMapper);
    }

    @Override
    public Song getById(int id) {
        return null;
    }

    @Override
    public boolean save(Song entity) {
        return false;
    }

    @Override
    public boolean updateById(Song entity, int _id) {
        return false;
    }

    @Override
    public boolean deleteById(int _id) {
        return false;
    }
}
