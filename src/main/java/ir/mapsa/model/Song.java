package ir.mapsa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "songEntity")
@Table(name = "SONG_TABLE")
public class Song implements Serializable {


    @Id
    @Column(name = "SONG_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SONG_ID_SEQ")
    @SequenceGenerator(name = "songSeq", sequenceName = "SONG_ID_SEQ")
    private Long songId;

    @Column(columnDefinition = "varchar(50)")
    private String title;

    private Double duration;


    @Column(name = "DATE_OF_RELEASE")
    private LocalDate releaseDate;

    private String genre;
    @Column(name = "FILE_PATH",columnDefinition = "varchar(50)")
    private String filePath;
    @Version
    private Integer version;

    //****************
    //****************
    //Constructors


    public Song() {
    }

    public Song(String title, Double duration, LocalDate releaseDate, String genre, String filePath) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.filePath = filePath;
    }

    public Song(Long songId, String title, Double duration, LocalDate releaseDate, String genre, String filePath) {
        this.songId = songId;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.filePath = filePath;
    }


    //****************
    //****************
    //Getters And Setters


    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getVersion() {
        return version;
    }

    //****************
    //****************
    //ToString


    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", filePath='" + filePath + '\'' +
                ", version=" + version +
                '}';
    }
}
