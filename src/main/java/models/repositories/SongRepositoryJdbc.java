/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import models.entities.Album;
import models.entities.Artist;
import models.entities.Genre;
import models.entities.Song;
import models.repositories.interfaces.RowMapper;
import models.repositories.interfaces.SongRepository;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
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
            .album_id(
                    Album.builder()
                            .id(row.getInt("album_id")).title(row.getString("album_title"))
                            .description(row.getString("album_description"))
                            .cover_img(row.getString("album_img"))
                            .build())
            .genre_id(Genre.builder()
                    .id(row.getInt("genre_id"))
                    .name(row.getString("genre_name"))
                    .description(row.getString("genre_description"))
                    .type(row.getString("genre_type"))
                    .build())
            .build();


    private final String GET_ALL = "SELECT song.id,song.artist_id,artist.email,artist.name,artist.lastname," +
            " artist.avatar_img,artist.created_at, song.title,song.cover_img,song.music_url,song.album_id" +
            " AS album_id, album.title AS album_title, album.description as album_description, album.cover_img" +
            " as album_img, genre.id AS genre_id, genre.name AS genre_name, genre.description as genre_description, " +
            "genre.type as genre_type FROM song INNER JOIN artist on song.artist_id=artist.id LEFT JOIN album on " +
            "song.album_id=album.id LEFT JOIN genre on song.genre_id = genre.id ";


    @Override
    public List<Song> getAll() {
        return simpleJdbc.query(GET_ALL, songRowMapper);
    }

    @Override
    public Song getById(int id) {
        String getById = GET_ALL + " WHERE song.id= ?";
        List<Song> songs = simpleJdbc.query(getById, songRowMapper, id);
        return !songs.isEmpty() ? songs.get(0) : null;
    }

    @Override
    public boolean save(Song entity) {
        String save =
                "INSERT INTO `song`(`artist_id`, `title`, `cover_img`, `music_url`, `album_id`, `genre_id`) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        return simpleJdbc.update(save, entity.getArtist_id().getId(), entity.getTitle(), entity.getCover_img(),
                entity.getMusic_url(), entity.getAlbum_id(), entity.getGenre_id().getId());
    }

    @Override
    public boolean updateById(Song entity, int _id) {
        return false;
    }

    @Override
    public boolean deleteById(int _id) {
        return false;
    }

    @Override
    public List<Song> searchByWords(String words, int filt) {
        String searchByWords = GET_ALL + " WHERE song.title LIKE \"%" + words + "%\" or album.title LIKE \"%" + words + "%\"" +
                " or artist.name LIKE \"%" + words + "%\" or genre.name LIKE \"%" + words + "%\" ORDER BY song.id DESC LIMIT 100";


        return simpleJdbc.query(searchByWords, songRowMapper);
    }

    @Override
    public List<Song> getByArtistId(int artist_id) {
        String getByArtistId = GET_ALL + " WHERE song.artist_id = ?";
        return simpleJdbc.query(getByArtistId, songRowMapper, artist_id);
    }

    @Override
    public List<Song> getByGenreId(int genre_id) {
        String getByGenreId = GET_ALL + " WHERE song.genre_id = ?";
        return simpleJdbc.query(getByGenreId, songRowMapper, genre_id);
    }

    @Override
    public List<Song> getByAlbumId(int album_id) {
        String getByAlbumId = GET_ALL + " WHERE song.album_id = ?";
        return simpleJdbc.query(getByAlbumId, songRowMapper, album_id);
    }

    @Override
    public List<Song> getFromLiked(int user_id) {
        String getFromLiked=GET_ALL + "INNER JOIN liked on song.id = liked.song_id WHERE liked.user_id = ?";
        return simpleJdbc.query(getFromLiked,songRowMapper,user_id);
    }
}
