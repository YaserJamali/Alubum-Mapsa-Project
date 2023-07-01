package ir.mapsa.repository;

import ir.mapsa.model.Album;

import java.util.List;

public interface BaseRepository<T, N extends Number> {
    T save(T t);

    T update(T t);

    T delete(N id);

    T findById(N id);

    List<T> findByExample(String s);


    List<T> findAll();
}
