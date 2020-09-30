package models.entities;

public class Song {
    private int id;
    private Artist artist_id;
    private String title;
    private String cover_img;
    private String music_url;
    private Album album_id;

    public Song(int id, Artist artist_id, String title, String cover_img, String music_url, Album album_id) {
        this.id = id;
        this.artist_id = artist_id;
        this.title = title;
        this.cover_img = cover_img;
        this.music_url = music_url;
        this.album_id = album_id;
    }

    public int getId() {
        return id;
    }

    public Artist getArtist_id() {
        return artist_id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover_img() {
        return cover_img;
    }

    public String getMusic_url() {
        return music_url;
    }

    public Album getAlbum_id() {
        return album_id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", artist_id=" + artist_id +
                ", title='" + title + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", music_url='" + music_url + '\'' +
                ", album_id=" + album_id +
                '}';
    }
}
