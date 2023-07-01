package ir.mapsa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "albumEntity")
@Table(name = "ALBUM_TABLE")
public class Album implements Serializable {

    @Id
    @Column(name = "ALBUM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_ID_SEQ")
    @SequenceGenerator(name = "albumSeq", sequenceName = "ALBUM_ID_SEQ",initialValue = 1,allocationSize = 1)
    private Long albumId;
    @Column(columnDefinition = "varchar(50)")
    private String title;


    @Column(name = "DATE_OF_RELEASE")
    private LocalDate releaseDate;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Artist> artists = new HashSet<>();
    @Version
    private Integer version;

    //****************
    //****************
    //Constructors

    public Album() {
    }

    public Album(String title, LocalDate releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Album(Long albumId, String title, LocalDate releaseDate) {
        this.albumId = albumId;
        this.title = title;
        this.releaseDate = releaseDate;
    }


    //****************
    //****************
    //Getters And Setters

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Integer getVersion() {
        return version;
    }


    //****************
    //****************
    //ToString


    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", artists=" + artists +
                ", version=" + version +
                '}';
    }
}
