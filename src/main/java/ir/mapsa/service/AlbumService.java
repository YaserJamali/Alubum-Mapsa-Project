package ir.mapsa.service;

import com.google.gson.Gson;
import ir.mapsa.model.Album;
import ir.mapsa.repository.AlbumRepository;

import java.time.LocalDate;

public class AlbumService implements BaseService<Album, Long> {

    private static AlbumService instance;


    private final AlbumRepository repository;

    private AlbumService() {
        repository = AlbumRepository.getInstance();
    }


    public static AlbumService getInstance() {
        if (instance == null) {
            instance = new AlbumService();
            return instance;
        }
        return instance;
    }


    @Override
    public void save(Album album) {
        repository.save(album);
    }

    @Override
    public void update(Album album) {
        repository.update(album);

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
        Album album = repository.findById(id);
        if (album == null) {
            return "Error:The Author Id Is Not Exist";
        }
        return album.toString();
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
        return new Gson().toJson(repository.findAll());
    }

    public String saveInstance(String name, LocalDate releaseDate) {
        if (name != null && releaseDate != null) {
            Album album = new Album();
            album.setTitle(name);
            album.setReleaseDate(releaseDate);

            save(album);
            return album.toString();
        }
        return "The Information are Invalid or incomplete";
    }

    public String updateInstance(Long id, String name, LocalDate releaseDate) {
        if (id != null && releaseDate != null && name != null) {
            Album album = repository.findById(id);
            if (album != null) {
                album.setTitle(name);
                album.setReleaseDate(releaseDate);
                update(album);
                return album.toString();
            }
            return "Error:The Album Id Is Not Exist";
        }
        return "Please Fill All Fields";
    }

}


