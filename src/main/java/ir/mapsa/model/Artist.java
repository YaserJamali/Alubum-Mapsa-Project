package ir.mapsa.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "artistEntity")
@Table(name = "ARTIST_TABLE")

public class Artist implements Serializable {
    @Id
    @Column(name = "ARTIST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_ID_SEQ")
    @SequenceGenerator(name = "artistSeq", sequenceName = "ARTIST_ID_SEQ")
    private Long artistId;
    @Column(columnDefinition = "varchar(50)")
    private String name;
    @Column(columnDefinition = "varchar(250)")
    private String bio;
    @Column(columnDefinition = "varchar(50)")
    private String nationality;

    @Version
    private Integer version;


    //****************
    //****************
    //Constructors

    public Artist() {
    }

    public Artist(String name, String bio, String nationality) {
        this.name = name;
        this.bio = bio;
        this.nationality = nationality;
    }

    public Artist(Long artistId, String name, String bio, String nationality) {
        this.artistId = artistId;
        this.name = name;
        this.bio = bio;
        this.nationality = nationality;
    }

    //****************
    //****************
    //Getters And Setters

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getVersion() {
        return version;
    }


    //****************
    //****************
    //ToString


    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", nationality='" + nationality + '\'' +
                ", version=" + version +
                '}';
    }
}
