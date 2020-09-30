/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.entities;

public class Comment {
    private int id;
    private User user_id;
    private Song song_id;
    private String user_text;

    public Comment(int id, User user_id, Song song_id, String user_text) {
        this.id = id;
        this.user_id = user_id;
        this.song_id = song_id;
        this.user_text = user_text;
    }

    public int getId() {
        return id;
    }

    public User getUser_id() {
        return user_id;
    }

    public Song getSong_id() {
        return song_id;
    }

    public String getUser_text() {
        return user_text;
    }
}
