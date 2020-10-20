package models.entities;

import annotation.Constraint;
import annotation.ManyToOne;
import annotation.Table;
import lombok.*;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "liked")
public class Liked {
    @Constraint(pk = true, uniq = true)
    private int id;
    @Constraint(notNull = true)
    @ManyToOne
    private User user_id;
    @Constraint(notNull = true)
    @ManyToOne
    private Song song_id;

    public Liked(int id,User user_id, Song song_id) {
        this.id=id;
        this.user_id = user_id;
        this.song_id = song_id;
    }

}
