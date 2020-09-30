package models.entities;

public class Liked {
    private User user_id;
    private Song song_id;

    public Liked(User user_id, Song song_id) {
        this.user_id = user_id;
        this.song_id = song_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public Song getSong_id() {
        return song_id;
    }
}
