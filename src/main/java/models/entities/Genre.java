/**
 * @author Gilyazov Marat
 * 11-905
 */

package models.entities;

import annotation.Constraint;
import annotation.Table;
import lombok.*;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "genre")
public class Genre  {
    @Constraint(pk = true)
    int id;
    String name;
    String description;
    String type;

    public Genre(){}

    public Genre(int id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id;
    }


}


