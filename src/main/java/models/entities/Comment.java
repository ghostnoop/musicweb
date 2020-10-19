/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.entities;

import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class Comment {
    private int id;
    private User user_id;
    private Song song_id;
    private String user_text;
    private Date created_at;


    public Comment(int id, User user_id, Song song_id, String user_text, Date created_at) {
        this.id = id;
        this.user_id = user_id;
        this.song_id = song_id;
        this.user_text = user_text;
        this.created_at = created_at;
    }
}
