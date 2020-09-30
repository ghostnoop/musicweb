

package models.entities;

import lombok.Data;

@Data
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

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCover_img() {
        return cover_img;
    }

    public Artist getArtist_id() {
        return artist_id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", artist_id=" + artist_id.getName() +
                '}';
    }
}
