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
public class Genre  {
//    todo orm
    int id;
    String name;
    String description;
    String type;

    public Genre(){

    }

    public Genre(int id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }
}


