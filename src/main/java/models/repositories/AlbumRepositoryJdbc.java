/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import app.SQLGenerator;
import models.entities.Album;
import models.entities.Artist;
import models.repositories.interfaces.AlbumRepository;
import models.repositories.interfaces.RowMapper;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
import java.util.List;

public class AlbumRepositoryJdbc implements AlbumRepository {
    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    private final RowMapper<Album> albumRowMapper = row -> Album.builder()
            .id(row.getInt(1))
            .title(row.getString("title"))
            .description(row.getString("description"))
            .cover_img(row.getString("cover_img"))
            .artist_id(Artist.builder()
                    .id(row.getInt(5))
                    .email(row.getString("email"))
                    .name(row.getString("name"))
                    .lastname(row.getString("lastname"))
                    .avatar_img(row.getString("avatar_img"))
                    .password(row.getString("password"))
                    .created_at(row.getDate("created_at")).build()
            ).build();

    public AlbumRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    @Override
    public List<Album> getAll() {
        String GET_ALL = "SELECT * FROM `album` INNER JOIN `artist` ON `artist_id`=`artist`.`id`";
        return simpleJdbc.query(GET_ALL, albumRowMapper);
    }

    @Override
    public Album getById(int id) {
        String GET_BY_ID = "SELECT * FROM `album` INNER JOIN `artist` ON `artist_id`=`artist`.`id` WHERE `album`.`id`= ? ";
        List<Album> albums = simpleJdbc.query(GET_BY_ID, albumRowMapper, id);
        return !albums.isEmpty() ? albums.get(0) : null;
    }

    @Override
    public boolean save(Album entity) {
        return simpleJdbc.update(SQLGenerator.generateSave(Album.class), entity.getTitle(), entity.getDescription(), entity.getCover_img(), entity.getArtist_id().getId());
    }

    @Override
    public boolean updateById(Album entity, int _id) {
        String UPD_BY_ID = SQLGenerator.generateUpdateById(Album.class);
        return simpleJdbc.update(UPD_BY_ID, entity.getTitle(), entity.getDescription(), entity.getCover_img(), entity.getArtist_id().getId(), _id);
    }

    @Override
    public boolean deleteById(int _id) {
        String DEL_BY_ID = SQLGenerator.generateDeleteById(Album.class);
        return simpleJdbc.update(DEL_BY_ID, _id);
    }
}
