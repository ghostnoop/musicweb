/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.entities;

import lombok.*;

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

    public Comment(int id, User user_id, Song song_id, String user_text) {
        this.id = id;
        this.user_id = user_id;
        this.song_id = song_id;
        this.user_text = user_text;
    }


}
