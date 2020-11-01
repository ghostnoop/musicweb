/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import models.entities.Comment;
import models.entities.User;
import models.repositories.interfaces.CommentRepository;
import models.repositories.interfaces.RowMapper;
import models.repositories.jdbcUtils.SimpleJdbc;

import javax.sql.DataSource;
import java.util.List;

public class CommentRepositoryJdbc implements CommentRepository {
    private final DataSource dataSource;
    private final SimpleJdbc simpleJdbc;

    private final RowMapper<Comment> commentRowMapperWithoutSong = row -> Comment.builder()
            .id(row.getInt("comment_id"))
            .user_id(User.builder()
                    .id(row.getInt("user_id"))
                    .name(row.getString("user_name"))
                    .lastname(row.getString("user_lastname")).build()
            ).user_text(row.getString("user_text"))
            .created_at(row.getDate("created_at"))
            .build();

    public CommentRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.simpleJdbc = new SimpleJdbc(dataSource);
    }

    @Override
    public List<Comment> getAllBySongId(int _id) {
        String getAllBySongId = "SELECT comment.id as comment_id, user.id as user_id, user.name as user_name, " +
                "user.lastname as user_lastname, user_text, comment.created_at as created_at FROM comment INNER JOIN user on comment.user_id = user.id " +
                "WHERE comment.song_id= ? ORDER BY comment.id DESC LIMIT 100 ";
        return simpleJdbc.query(getAllBySongId, commentRowMapperWithoutSong, _id);
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment getById(int id) {
        return null;
    }

    @Override
    public boolean save(Comment entity) {
        String SaveSql = "Insert into comment(user_id, song_id, user_text) Values(?,?,?)";
        return simpleJdbc.update(SaveSql, entity.getUser_id().getId(), entity.getSong_id().getId(), entity.getUser_text());
    }

    @Override
    public boolean updateById(Comment entity, int _id) {
        return false;
    }

    @Override
    public boolean deleteById(int _id) {
        return false;
    }
}
