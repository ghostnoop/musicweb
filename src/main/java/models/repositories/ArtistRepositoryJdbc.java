/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import app.SQLGenerator;
import models.entities.Artist;
import models.repositories.interfaces.ArtistRepository;
import models.repositories.interfaces.RowMapper;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
import java.util.List;

public class ArtistRepositoryJdbc implements ArtistRepository {
    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    private final RowMapper<Artist> artistRowMapper = row -> Artist.builder()
            .id(row.getInt("id"))
            .email(row.getString("email"))
            .name(row.getString("name"))
            .lastname(row.getString("lastname"))
            .password(row.getString("password"))
            .avatar_img(row.getString("avatar_img"))
            .created_at(row.getDate("created_at"))
            .build();

    private final RowMapper<Artist> publicArtistRowMapper = row -> Artist.builder()
            .id(row.getInt("id"))
            .email(row.getString("email"))
            .name(row.getString("name"))
            .lastname(row.getString("lastname"))
            .avatar_img(row.getString("avatar_img"))
            .build();

    private final String IS_EMAIL_EXIST = "SELECT * FROM artist WHERE email= ? LIMIT 1";

    public ArtistRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    @Override
    public List<Artist> getAll() {
        return simpleJdbc.query(SQLGenerator.generateGetAll(Artist.class), artistRowMapper);
    }

    @Override
    public List<Artist> getTopArtistByLiked() {
        String topArtistSql = "SELECT song.artist_id as id,artist.email,artist.name,artist.lastname," +
                "artist.avatar_img, COUNT(liked.song_id) as liked_count  FROM liked  INNER JOIN song ON " +
                "liked.song_id=song.id INNER JOIN artist ON artist_id=artist.id GROUP BY artist_id HAVING " +
                "MAX(liked.song_id) ORDER BY liked_count DESC LIMIT 5";
        return simpleJdbc.query(topArtistSql, publicArtistRowMapper);

    }

    @Override
    public Artist getById(int id) {
        List<Artist> artists = simpleJdbc.query(SQLGenerator.generateGetById(Artist.class), artistRowMapper, id);
        return !artists.isEmpty() ? artists.get(0) : null;
    }

    @Override
    public boolean save(Artist entity) {
        return simpleJdbc.update(SQLGenerator.generateSave(Artist.class),
                entity.getEmail(),
                entity.getName(),
                entity.getLastname(),
                entity.getAvatar_img(),
                entity.getPassword()
        );
    }

    @Override
    public boolean updateById(Artist entity, int _id) {
        return simpleJdbc.update(SQLGenerator.generateUpdateById(Artist.class),
                entity.getEmail(),
                entity.getName(),
                entity.getLastname(),
                entity.getAvatar_img(),
                entity.getPassword(),
                _id
        );
    }

    @Override
    public boolean deleteById(int _id) {
        return simpleJdbc.update(SQLGenerator.generateDeleteById(Artist.class), _id);
    }

    @Override
    public boolean emailExist(String email) {
        List<Artist> Artist = simpleJdbc.query(IS_EMAIL_EXIST, artistRowMapper, email);
        return !Artist.isEmpty();
    }

    @Override
    public Artist getByEmail(String email) {
        List<Artist> Artist = simpleJdbc.query(IS_EMAIL_EXIST, artistRowMapper, email);
        return !Artist.isEmpty() ? Artist.get(0) : null;
    }
}
