/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import models.entities.Artist;
import models.entities.Comment;
import models.entities.Liked;
import models.repositories.interfaces.LikedRepository;
import models.repositories.interfaces.RowMapper;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikedRepositoryJdbc implements LikedRepository {

    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    public LikedRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    private final RowMapper<Liked> simpleLikedRowMapper = row -> Liked.builder()
            .id(row.getInt("liked_id")).build();

    @Override
    public boolean isUserLikedSong(int user_id, int song_id) {
        String isLikedSql="SELECT id as liked_id FROM liked WHERE user_id= ? and song_id=?";
        return !simpleJdbc.query(isLikedSql,simpleLikedRowMapper,user_id,song_id).isEmpty();
    }

    @Override
    public int getCountOfLikesBySongId(int _id) {
       String getCount = "SELECT COUNT(user_id) AS count FROM liked WHERE song_id= ? ";

        ResultSet resultSet = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(getCount)) {
            statement.setInt(1,_id);

            resultSet = statement.executeQuery();

            resultSet.next();

            int result=resultSet.getInt("count");

            resultSet.close();
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }



    @Override
    public List<Liked> getAll() {
        return null;
    }

    @Override
    public Liked getById(int id) {
        return null;
    }

    @Override
    public boolean save(Liked entity) {
        return false;
    }

    @Override
    public boolean updateById(Liked entity, int _id) {
        return false;
    }

    @Override
    public boolean deleteById(int _id) {
        return false;
    }
}
