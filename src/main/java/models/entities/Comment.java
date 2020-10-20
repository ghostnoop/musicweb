/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.entities;

import annotation.Constraint;
import annotation.ManyToOne;
import annotation.Table;
import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Constraint(pk = true, uniq = true)
    private int id;
    @Constraint(notNull = true)
    @ManyToOne
    private User user_id;
    @Constraint(notNull = true)
    @ManyToOne
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
