package models.entities;

import lombok.*;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class Liked {
    private int id;
    private User user_id;
    private Song song_id;

    public Liked(int id,User user_id, Song song_id) {
        this.id=id;
        this.user_id = user_id;
        this.song_id = song_id;
    }

}
