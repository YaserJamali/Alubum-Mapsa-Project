package ir.mapsa.service;

import ir.mapsa.model.Artist;
import ir.mapsa.repository.ArtistRepository;

import java.time.LocalDate;

public class ArtistService implements BaseService<Artist, Long> {


    private static ArtistService instance;


    private final ArtistRepository repository;

    private ArtistService() {
        repository = ArtistRepository.getInstance();
    }


    public static ArtistService getInstance() {
        if (instance == null) {
            instance = new ArtistService();
            return instance;
        }
        return instance;
    }


    @Override
    public void save(Artist artist) {
        repository.save(artist);
    }

    @Override
    public void update(Artist artist) {
        repository.update(artist);

    }

    @Override
    public String delete(Long id) {
        if (id != null && repository.findById(id) != null) {
            return repository.delete(id) + " Is Removed";
        }
        return "This ID: " + id + " IS Not Exist";
    }

    @Override
    public String findById(Long id) {
        Artist artist = repository.findById(id);
        if (artist == null) {
            return "Error:The Artist Id Is Not Exist";
        }
        return artist.toString();
    }

    @Override
    public String findByExample(String s) {
        if (s != null) {
            String temp = s.toLowerCase();
            return repository.findByExample(temp).toString();
        }
        return "Please Enter A Valid Title ";
    }

    @Override
    public String findAll() {
        return repository.findAll().toString();
    }

    public String saveInstance(String name, String bio, String nationality, LocalDate releaseDate) {
        if (name != null && releaseDate != null) {
            Artist artist = new Artist();
            artist.setBio(bio);
            artist.setName(name);
            artist.setNationality(nationality);

            save(artist);
            return artist.toString();
        }
        return "The Information are Invalid or incomplete";
    }

    public String updateInstance(Long id, String name, String bio, String nationality, LocalDate releaseDate) {
        if (id != null && releaseDate != null && name != null) {
            Artist artist = repository.findById(id);
            if (artist != null) {
                artist.setBio(bio);
                artist.setName(name);
                artist.setNationality(nationality);
                update(artist);
                return artist.toString();
            }
            return "Error:The Artist Id Is Not Exist";
        }
        return "Please Fill All Fields";
    }

}
