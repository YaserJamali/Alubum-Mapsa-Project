package ir.mapsa.service;

import ir.mapsa.model.Song;
import ir.mapsa.repository.SongRepository;

import java.time.LocalDate;

public class SongService implements BaseService<Song, Long> {


    private static SongService instance;


    private final SongRepository repository;

    private SongService() {
        repository = SongRepository.getInstance();
    }


    public static SongService getInstance() {
        if (instance == null) {
            instance = new SongService();
            return instance;
        }
        return instance;
    }


    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void update(Song song) {
        repository.update(song);

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
        Song song = repository.findById(id);
        if (song == null) {
            return "Error:The Author Id Is Not Exist";
        }
        return song.toString();
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

    public String saveInstance(String name, Double duration, LocalDate releaseDate, String genre, String filePath) {
        if (name != null && releaseDate != null) {
            Song song = new Song();
            song.setTitle(name);
            song.setDuration(duration);
            song.setReleaseDate(releaseDate);
            song.setGenre(genre);
            song.setFilePath(filePath);
            save(song);
            return song.toString();
        }
        return "The Information are Invalid or incomplete";
    }

    public String updateInstance(Long id, String name, Double duration, LocalDate releaseDate, String genre, String filePath) {
        if (id != null && releaseDate != null && name != null) {
            Song song = repository.findById(id);
            if (song != null) {
                song.setTitle(name);
                song.setDuration(duration);
                song.setReleaseDate(releaseDate);
                song.setGenre(genre);
                song.setFilePath(filePath);
                update(song);
                return song.toString();
            }
            return "Error:The Song Id Is Not Exist";
        }
        return "Please Fill All Fields";
    }

}
