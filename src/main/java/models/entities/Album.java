

package models.entities;

import lombok.*;

@Data
@ToString
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class Album {
    private int id;
    private String title;
    private String description;
    private String cover_img;
    private Artist artist_id;

    public Album(int id, String title, String description, String cover_img, Artist artist_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_img = cover_img;
        this.artist_id = artist_id;
    }
    public Album(int id, String title, String description, String cover_img, String artistName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cover_img = cover_img;
        this.artist_id = new Artist(artistName);

    }



}
