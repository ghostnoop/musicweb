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
@Table(name = "song")
public class Song {
    @Constraint(pk = true, uniq = true)
    private int id;
    @Constraint(notNull = true)
    @ManyToOne
    private Artist artist_id;
    private String title;
    private String cover_img;
    private String music_url;
    @Constraint(notNull = false)
    @ManyToOne
    private Album album_id;
    @Constraint(notNull = true)
    @ManyToOne
    private Genre genre_id;

    public Song(int id, Artist artist_id, String title, String cover_img, String music_url, Album album_id) {
        this.id = id;
        this.artist_id = artist_id;
        this.title = title;
        this.cover_img = cover_img;
        this.music_url = music_url;
        this.album_id = album_id;
    }

    public Song(int id, String title, String cover_img, String music_url, int artist_id, String name) {
        this.id = id;
        this.title = title;
        this.cover_img = cover_img;
        this.music_url = music_url;
        this.artist_id = new Artist(artist_id, name);
    }


    public Song(int id, Artist artist_id, String title, String cover_img, String music_url, Album album_id, Genre genre_id) {
        this.id = id;
        this.artist_id = artist_id;
        this.title = title;
        this.cover_img = cover_img;
        this.music_url = music_url;
        this.album_id = album_id;
        this.genre_id = genre_id;
    }
}
