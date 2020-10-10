/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import models.entities.Song;
import models.entities.User;
import service.SQLGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SongRepositoryJdbc implements SongRepository {
    private Connection connection;

    public SongRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Song> getAll() {
        String GET_ALL_SONGS = "SELECT `song`.`id`,`title`,`cover_img`,`music_url`,`artist`.`id`," +
                "`artist`.`name` FROM `song` INNER JOIN `artist` on `song`.`atist_id`= `artist`.`id`";
        List<Song> songs = new LinkedList<>();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_SONGS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                songs.add(new Song(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getString(6)
                ));
            }
            System.out.println(songs.get(0));
            return songs;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;

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
