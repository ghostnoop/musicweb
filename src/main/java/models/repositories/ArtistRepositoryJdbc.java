/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.repositories;

import app.Constants;
import models.entities.Artist;
import models.repositories.interfaces.ArtistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ArtistRepositoryJdbc implements ArtistRepository {
    private Connection connection;

    public ArtistRepositoryJdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Artist> getAll() {
        String GET_ALL_SONGS = "SELECT `id`,`name`,`avatar_img` FROM `artist` WHERE 1";
//        SELECT `song`.`id`,`song`.`title`,`song`.`cover_img`,`song`.`music_url`,`artist`.`id`,`artist`.`name` FROM `song` INNER JOIN `artist` on `song`.`atist_id`= `artist`.`id` INNER JOIN `album` on `song`.`album_id`=`album`.`id`
        List<Artist> artists = new LinkedList<>();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_SONGS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                artists.add(new Artist(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
            System.out.println(artists);
            return artists;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Artist getById(int id) {
        return null;
    }

    @Override
    public boolean save(Artist entity) {
        return false;
    }

    @Override
    public boolean updateById(Artist entity, int _id) {
        return false;
    }

    @Override
    public boolean deleteById(int _id) {
        return false;
    }

    @Override
    public boolean emailExist(String email) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT email FROM artist WHERE email= ? LIMIT 1");
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;

    }
}
