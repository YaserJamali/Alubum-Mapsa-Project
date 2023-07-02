package ir.mapsa;


import ir.mapsa.model.Album;
import ir.mapsa.model.Artist;
import ir.mapsa.model.Song;
import ir.mapsa.service.AlbumService;
import ir.mapsa.service.ArtistService;
import ir.mapsa.service.SongService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Album album = new Album("Hell",
                LocalDate.of(1400, 12, 12));
        Song song = new Song("Go To Hell", 2.56,
                LocalDate.of(1400, 2, 3), "Metal", "here");
        Artist artist = new Artist("James",
                "He Had Best Voice In His Genre",
                "American");
        album.getArtists().add(artist);

        SongService songService=SongService.getInstance();
        ArtistService artistService=ArtistService.getInstance();
        AlbumService albumService=AlbumService.getInstance();

        System.out.println(songService.findByExample("hell"));
        System.out.println(songService.findAll());
        System.out.println(songService.findById(1L));
        songService.save(song);

        System.out.println(songService.updateInstance(2L, "yaser",
                3.56, LocalDate.now(), "Rap", "Out Of Root"));


//        System.out.println(albumService.saveInstance("new album", LocalDate.now()));
//        System.out.println(albumService.updateInstance(102L, "update new fore test 2", LocalDate.EPOCH));
//        System.out.println(albumService.findByExample("update"));
        System.out.println(albumService.findById(102L));
//        System.out.println(albumService.delete(702L));


        System.out.println(artistService.saveInstance("new artist", "new bio artist", "new nationality", LocalDate.MAX));
        System.out.println(artistService.updateInstance(1L, "update artist", "bio update", "update nationality", LocalDate.MIN));


    }
}
